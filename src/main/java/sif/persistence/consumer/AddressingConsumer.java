package sif.persistence.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sif.persistence.dto.AddressingDTO;
import sif.persistence.service.AddressingService;

import java.time.LocalDateTime;


@Service
public class AddressingConsumer {

    @Autowired
    private AddressingService addressingService;

    @RabbitListener(queues = "${spring.rabbitmq.queues.names.addressing-get}")
    public void getAddressing(AddressingDTO addressingDTO) {
        System.out.println(LocalDateTime.now().toString());

        AddressingDTO saved = addressingService.create(addressingDTO);
        if (saved != null) {
            System.out.println("Address ingresado com sucesso: " + saved.toString());
        } else {
            System.out.println("Erro ao inserir Address ingresado");
        }
        System.out.println(LocalDateTime.now().toString());
    }
}
