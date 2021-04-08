package com.example.springherokupostgressdatabase.repository;

import com.example.springherokupostgressdatabase.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Long> {
}
