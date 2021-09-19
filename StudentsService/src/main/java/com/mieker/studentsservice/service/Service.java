package com.mieker.studentsservice.service;

import com.mieker.studentsservice.model.Student;

public interface Service {

    public void createFakeData();
    public Student getStudent(Long id);

}
