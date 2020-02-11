package com.github.nzadage.spring.service;

import com.github.nzadage.spring.beans.Subject;

public interface SubjectService {

	public Subject findById(Long subjectId);
	
	public Iterable<Subject> findAll();
	
	public Subject save(Subject subject);
	
	public Iterable<Subject> saveAll(Iterable<Subject> entities);
	
	public void deleteById(Long id);
	
	public void delete(Subject entity);
	
}
