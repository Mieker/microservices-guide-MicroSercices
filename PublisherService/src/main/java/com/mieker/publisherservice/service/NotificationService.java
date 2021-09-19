package com.mieker.publisherservice.service;

import com.mieker.publisherservice.model.Notification;
import com.mieker.publisherservice.model.StudentModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class NotificationService implements Service {

    private RestTemplate restTemplate;
    private RabbitTemplate rabbitTemplate;

    public NotificationService(RestTemplate restTemplate, RabbitTemplate rabbitTemplate) {
        this.restTemplate = restTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public StudentModel getStudentDataFromStudentService(Long id) {

        StudentModel studentModel = restTemplate
                .exchange("http://localhost:8090/students/" + id, HttpMethod.GET, HttpEntity.EMPTY, StudentModel.class)
                .getBody();
        return studentModel;
    }

    @Override
    public Notification createNotification(StudentModel studentModel) {

        Notification notification = new Notification(studentModel.getEmail());
        notification.setTitle("Witaj " + studentModel.getFirstName() + "!");
        notification.setBody("Miło, że jesteś z nami " + studentModel.getFirstName() + " " + studentModel.getLastName() + "!");
        return notification;
    }

    @Override
    public void sendNotification(Notification notification) {
        rabbitTemplate.convertAndSend("kurs", notification); 
    }
}
