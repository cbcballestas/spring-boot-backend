/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Student;
import com.example.demo.service.IStudentService;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

	private final IStudentService studentService;

	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

	@Autowired
	public StudentController(IStudentService studentService) {
		this.studentService = studentService;
	}

	@GetMapping
	public ResponseEntity<List<Student>> getStudents() {
		logger.info("Loading student list....");
		return studentService.getAllRecords();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable(name = "id") Long id) {
		logger.info("Loading student info...");
		return studentService.getRecordById(id);
	}

	@PostMapping
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
		logger.info("Saving student data....");
		return studentService.save(student);
	}

	/**
	 * Method which updates student's name or email
	 * 
	 * @param id
	 * @param name
	 * @param email
	 * @return Updated student
	 */
	@PutMapping("/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable(name = "id") Long id,
			@RequestParam(required = false) String name, @RequestParam(required = false) String email) {
		logger.info("Updating student data....");
		return studentService.updateStudent(id, name, email);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable(name = "id") Long id) {
		logger.info("Deleting student data....");
		return studentService.deleteById(id);
	}
}
