package com.mieker.receiverservice.service;

import com.mieker.receiverservice.model.Notification;
import org.springframework.stereotype.Component;

@Component
public class ReceiverService implements Service{

    @Override
    public void printMessage(Notification notification) {
        System.out.println("Receiver: " + notification.getEmail() + "\n"
                + "Title: " + notification.getTitle() + "\n" + "Message: " + notification.getBody());
    }

}
