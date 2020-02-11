package com.github.nzadage.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.nzadage.spring.beans.Student;
import com.github.nzadage.spring.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(path = "/api/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Student> getStudents(){
		Iterable<Student> list = studentService.findAll();
		return list;
	}
	
	@PostMapping(path = "/api/students",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Student> addStudents(@RequestBody List<Student> students){
		Iterable<Student> list = studentService.saveAll(students);
		return list;
	}
	
	@GetMapping(path = "/api/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudent(@PathVariable Long id){
		Student student = studentService.findById(id);
		return student;
	}
	
	@PutMapping(path = "/api/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudent(@RequestBody Student student, @PathVariable Long id){
		Student s = studentService.save(student);
		return s;
	}

}
