package com.studentregistration.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentregistration.student.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{

}
