package com.example.demo.repo;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface IStudentRepo extends IGenericRepo<Student, Long> {
	Optional<Student> findStudentByEmail(String email);
}
