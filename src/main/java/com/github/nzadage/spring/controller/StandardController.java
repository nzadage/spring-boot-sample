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

import com.github.nzadage.spring.beans.Standard;
import com.github.nzadage.spring.service.StandardService;

@RestController
public class StandardController {
	
	@Autowired
	private StandardService standardService;

	@GetMapping(path = "/api/standards/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Standard getStandard(@PathVariable Long id){
		Standard standard = standardService.findById(id);
		return standard;
	}
	
	@GetMapping(path = "/api/standards", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Standard> getStandards(){
		Iterable<Standard> list = standardService.findAll();
		return list;
	}

	@PostMapping(path = "/api/standards",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Standard> addStandards(@RequestBody List<Standard> standards){
		Iterable<Standard> list = standardService.saveAll(standards); //standardRepository.saveAll(standards);
		return list;
	}
	
	@PutMapping(path = "/api/standards/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Standard updateStandard(@RequestBody Standard standard, @PathVariable Long id){
		Standard s = standardService.save(standard);
		return s;
	}
}
