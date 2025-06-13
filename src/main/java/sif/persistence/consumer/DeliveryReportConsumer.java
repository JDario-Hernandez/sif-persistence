package sif.persistence.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sif.persistence.dto.ProgramingDTO;
import sif.persistence.service.ProgramingService;

import java.time.LocalDateTime;

@Service
public class DeliveryReportConsumer {

    @Autowired
    private ProgramingService programingService;
/*
    @RabbitListener(queues = "${spring.rabbitmq.queues.names.deliveryreport-get}")
    public void getProgramming(ProgramingDTO programingDTO) {

        System.out.println(LocalDateTime.now().toString());
        ProgramingDTO saved = programingService.create(programingDTO);
        if (saved != null) {
            System.out.println("Programming ingresado com sucesso: " + saved.toString());
        } else {
            System.out.println("Erro ao inserir Programming ingresado");
        }
        System.out.println(LocalDateTime.now().toString());
    }*/
}
