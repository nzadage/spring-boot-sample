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

import com.github.nzadage.spring.beans.Subject;
import com.github.nzadage.spring.service.SubjectService;

@RestController
public class SubjectController {
	
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping(path = "/api/subjects/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Subject getSubject(@PathVariable Long id){
		Subject subject = subjectService.findById(id);
		return subject;
	}
	
	@GetMapping(path = "/api/subjects", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Subject> getSubjects(){
		Iterable<Subject> list = subjectService.findAll();
		return list;
	}

	@PostMapping(path = "/api/subjects",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Subject> addSubjects(@RequestBody List<Subject> subjects){
		Iterable<Subject> list = subjectService.saveAll(subjects); //standardRepository.saveAll(standards);
		return list;
	}
	
	@PutMapping(path = "/api/subjects/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Subject updateSubject(@RequestBody Subject subject, @PathVariable Long id){
		Subject s = subjectService.save(subject);
		return s;
	}
	
}
