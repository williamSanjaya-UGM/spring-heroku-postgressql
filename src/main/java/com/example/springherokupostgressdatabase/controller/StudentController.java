package com.example.springherokupostgressdatabase.controller;

import com.example.springherokupostgressdatabase.entity.Student;
import com.example.springherokupostgressdatabase.exception.ResourceNotFoundException;
import com.example.springherokupostgressdatabase.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable Long studentId) throws ResourceNotFoundException {
        return studentService.getStudentById(studentId);
    }
}
