package com.example.springherokupostgressdatabase.controller;

import com.example.springherokupostgressdatabase.entity.Student;
import com.example.springherokupostgressdatabase.entity.Subject;
import com.example.springherokupostgressdatabase.exception.ResourceNotFoundException;
import com.example.springherokupostgressdatabase.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @PostMapping
    public Subject addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }

    @GetMapping
    public List<Subject> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{subjectId}")
    public Subject getSubjectById(@PathVariable Long subjectId) throws ResourceNotFoundException {
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping("/{subjectId}")
    public Student addStudent(@PathVariable long subjectId, @RequestBody Student student) throws ResourceNotFoundException {
        return subjectService.addStudent(subjectId, student);
    }
}
