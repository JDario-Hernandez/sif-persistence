package sif.persistence.config;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.amqp.SimpleRabbitListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.interceptor.MethodInvocationRecoverer;
import org.springframework.retry.interceptor.RetryInterceptorBuilder;
import org.springframework.retry.interceptor.RetryOperationsInterceptor;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    @Value("${spring.rabbitmq.queues.names.addressing-get}")
    private List<String> consumerQueues;

    @Bean
    public DirectExchange deadLetterExchange() {
        return new DirectExchange("deadLetterExchange");
    }

    @Bean
    public List<Queue> consumerQueues() {
        List<Queue> queues = new ArrayList<>();
        for (String queueName : consumerQueues) {
            Map<String, Object> args = new HashMap<>();
            args.put("x-dead-letter-exchange", "deadLetterExchange");
            args.put("x-dead-letter-routing-key", queueName + ".dlq");
            queues.add(new Queue(queueName, true, false, false, args));
        }
        return queues;
    }

    @Bean
    public List<Queue> deadLetterQueues() {
        List<Queue> dlqs = new ArrayList<>();
        for (String queueName : consumerQueues) {
            dlqs.add(new Queue(queueName + ".dlq", true));
        }
        return dlqs;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin admin = new RabbitAdmin(connectionFactory);
        admin.declareExchange(deadLetterExchange());
        for (Queue queue : consumerQueues()) {
            admin.declareQueue(queue);
        }
        for (Queue dlq : deadLetterQueues()) {
            admin.declareQueue(dlq);
        }
        return admin;
    }

    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(
            ConnectionFactory connectionFactory,
            SimpleRabbitListenerContainerFactoryConfigurer configurer) {

        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        configurer.configure(factory, connectionFactory);

        factory.setAdviceChain(retryInterceptor());

        return factory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RetryOperationsInterceptor retryInterceptor() {
        return RetryInterceptorBuilder.stateless()
                .maxAttempts(3)
                .backOffOptions(10000, 1.0, 10000)
                .recoverer(new MethodInvocationRecoverer<Object>() {
                    @Override
                    public Object recover(Object[] args, Throwable cause) {
                        return cause;
                    }
                })
                .build();
    }
}