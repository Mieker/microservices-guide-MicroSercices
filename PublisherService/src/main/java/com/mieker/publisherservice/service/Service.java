package com.mieker.publisherservice.service;

import com.mieker.publisherservice.model.Notification;
import com.mieker.publisherservice.model.StudentModel;

public interface Service {

    public StudentModel getStudentDataFromStudentService(Long id);
    public Notification createNotification(StudentModel studentModel);
    public void sendNotification(Notification notification);
}
