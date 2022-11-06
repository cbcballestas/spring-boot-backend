package com.example.demo.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.exception.GlobalException;
import com.example.demo.model.Student;
import com.example.demo.repo.IGenericRepo;
import com.example.demo.repo.IStudentRepo;
import com.example.demo.service.IStudentService;
import com.example.demo.util.RestUtil;
import com.example.demo.util.StudentUtil;

@Service
public class StudentImpl extends CRUDImpl<Student, Long> implements IStudentService {

	private final IStudentRepo studentRepository;

	private static final Logger logger = LoggerFactory.getLogger(StudentImpl.class);

	@Autowired
	public StudentImpl(IStudentRepo studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	protected IGenericRepo<Student, Long> getRepo() {
		return studentRepository;
	}

	@Override
	public ResponseEntity<Student> save(Student student) {

		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

		if (studentOptional.isPresent()) {
			logger.error("Email taken....");
			throw new GlobalException("Email taken", HttpStatus.BAD_REQUEST);
		}

		logger.info("Student data has been saved....");

		return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
	}

	@Override
	@Transactional
	public ResponseEntity<Student> updateStudent(Long id, String name, String email) {
		Student student = RestUtil.checkFound(studentRepository.findById(id), id);

		if (StudentUtil.isDifferent(student.getName(), name)) {
			student.setName(name);
		}
		if (StudentUtil.isDifferent(student.getEmail(), email)) {

			// Verify is email has been taken
			Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);

			if (studentOptional.isPresent()) {
				logger.error("Email taken....");
				throw new GlobalException("Email taken", HttpStatus.BAD_REQUEST);
			}

			student.setEmail(email);
		}

		return ResponseEntity.ok(student);
	}

}
