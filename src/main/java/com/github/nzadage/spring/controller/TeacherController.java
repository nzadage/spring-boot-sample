package com.github.nzadage.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.nzadage.spring.beans.Teacher;
import com.github.nzadage.spring.repository.TeacherRepository;
import com.github.nzadage.spring.service.TeacherService;

@RestController
public class TeacherController {
	
	@Autowired
	private TeacherService teacherService;

	@GetMapping(path = "/api/teachers/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Teacher getTeacher(@PathVariable Long id){
		Teacher teacher = teacherService.findById(id);
		return teacher;
	}
	
	@GetMapping(path = "/api/teachers", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Teacher> getTeachers(){
		Iterable<Teacher> list = teacherService.findAll();
		return list;
	}
	
	@PostMapping(path = "/api/teachers",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Teacher> addTeachers(@RequestBody List<Teacher> teachers){
		Iterable<Teacher> list = teacherService.saveAll(teachers);
		return list;
	}
	
	@PutMapping(path = "/api/teachers/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable Long id){
		Teacher t = teacherService.save(teacher);
		return t;
	}
	
	@DeleteMapping(path = "/api/teachers/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Teacher deleteTeacher(@RequestBody Teacher teacher, @PathVariable Long id){
		Teacher t = teacherService.save(teacher);
		return t;
	}
}
