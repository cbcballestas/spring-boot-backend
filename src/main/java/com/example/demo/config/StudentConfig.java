package com.example.demo.config;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Student;
import com.example.demo.repo.IStudentRepo;

@Configuration
public class StudentConfig {

	@Bean
	CommandLineRunner commandLineRunner(IStudentRepo studentRepository) {
		return args -> {
			Student carlos = new Student("Carlos", "carlos@gmail.com", LocalDate.of(1995, Month.FEBRUARY, 10));
			Student alva = new Student("Alva", "alva@gmail.com", LocalDate.of(1996, Month.FEBRUARY, 10));

			studentRepository.saveAll(List.of(carlos, alva));
		};
	}

}
