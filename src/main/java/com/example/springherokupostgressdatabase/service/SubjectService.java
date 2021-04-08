package com.example.springherokupostgressdatabase.service;

import com.example.springherokupostgressdatabase.entity.Student;
import com.example.springherokupostgressdatabase.entity.Subject;
import com.example.springherokupostgressdatabase.exception.ResourceNotFoundException;
import com.example.springherokupostgressdatabase.repository.StudentRepository;
import com.example.springherokupostgressdatabase.repository.SubjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private static final Logger logg= LoggerFactory.getLogger(SubjectService.class);

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private StudentRepository studentRepository;

    public Subject addSubject(Subject subject){
        logg.info("subject :"+subject);
        return subjectRepository.save(subject);
    }

    public List<Subject> getAllSubjects(){
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long subjectId) throws ResourceNotFoundException {
        return subjectRepository.findById(subjectId).orElseThrow(()->new ResourceNotFoundException("SubjectId not found"));
    }

    public Student addStudent(long subjectId, Student student) throws ResourceNotFoundException {
        return subjectRepository.findById(subjectId).map(subject -> {
            student.setSubject(subject);
            return studentRepository.save(student);
        }).orElseThrow(() -> new ResourceNotFoundException("subjectId " + subjectId + " not found"));
    }
}
