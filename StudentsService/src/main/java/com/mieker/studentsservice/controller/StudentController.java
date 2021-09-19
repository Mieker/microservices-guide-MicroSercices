package com.mieker.studentsservice.controller;

import com.mieker.studentsservice.model.Student;
import com.mieker.studentsservice.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    private Service studentService;

    @Autowired
    public StudentController(Service studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable Long id) {

        return new ResponseEntity<Student>(studentService.getStudent(id), HttpStatus.OK);
    }

}
