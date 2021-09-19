package com.mieker.studentsservice.service;

import com.mieker.studentsservice.model.Student;
import com.mieker.studentsservice.repository.StudentRepository;
import org.springframework.stereotype.Component;

@Component
public class StudentService implements Service {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
        createFakeData();

    }

    @Override
    public void createFakeData() {

        Student student1 = new Student("Albert", "Kowalski", "albi@wp.pl");
        Student student2 = new Student("Bartek", "Nowak", "bart@wp.pl");
        Student student3 = new Student("Celina", "Bogdanowicz", "celina@wp.pl");

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

    }

    @Override
    public Student getStudent(Long id) {
        return studentRepository.findById(id).get();
    }
}
