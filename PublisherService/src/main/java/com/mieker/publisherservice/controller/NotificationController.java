package com.mieker.publisherservice.controller;

import com.mieker.publisherservice.model.StudentModel;
import com.mieker.publisherservice.service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/{id}")
    public String sendNotification(@PathVariable Long id) {

        return "Powiadomienie zostało wysłane do subskrybenta.";
    }
}
