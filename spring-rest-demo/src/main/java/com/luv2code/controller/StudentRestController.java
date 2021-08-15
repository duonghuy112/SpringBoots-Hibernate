package com.luv2code.controller;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.bean.Student;
import com.luv2code.error.StudentErrorResponse;
import com.luv2code.exc.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> students;
	
	@PostConstruct
	public void loadData() {
		students = Arrays.asList(new Student("Nguyen", "Huy"),
								 new Student("Le", "Ngan"),
								 new Student("Phan", "Quyen"));
	}

	@GetMapping("/students")
	public List<Student> getStudent() {
		return students;
	}
	
	@GetMapping("/students/{studentId}")
	public Student get(@PathVariable int studentId) {
		if (studentId >= students.size() || studentId < 0) {
			throw new StudentNotFoundException("Not found student id: " + studentId);
		}
		return students.get(studentId);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}
}
