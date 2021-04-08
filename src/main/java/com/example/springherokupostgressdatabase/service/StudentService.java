package com.example.springherokupostgressdatabase.service;

import com.example.springherokupostgressdatabase.entity.Student;
import com.example.springherokupostgressdatabase.exception.ResourceNotFoundException;
import com.example.springherokupostgressdatabase.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Long studentId) throws ResourceNotFoundException {
        return studentRepository.findById(studentId).orElseThrow(()->new ResourceNotFoundException("Student Id not found"));
    }
}
