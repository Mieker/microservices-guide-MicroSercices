package com.mieker.receiverservice.controller;

import com.mieker.receiverservice.model.Notification;
import com.mieker.receiverservice.service.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReceiverController {

    private RabbitTemplate rabbitTemplate;
    private final Service receiverService;

    public ReceiverController(RabbitTemplate rabbitTemplate, Service receiverService) {
        this.rabbitTemplate = rabbitTemplate;
        this.receiverService = receiverService;
    }

    @RabbitListener(queues = "kurs")
    public void listenMessage(Notification notification) {

        receiverService.printMessage(notification);
    }


}
