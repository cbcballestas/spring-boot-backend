package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.model.Student;

public interface IStudentService extends ICRUD<Student, Long> {
	ResponseEntity<Student> updateStudent(Long id, String name, String email);
}
