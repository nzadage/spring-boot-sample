package com.github.nzadage.spring.service;

import com.github.nzadage.spring.beans.Student;

public interface StudentService {
	
	public Student findById(Long studentId);
	
	public Iterable<Student> findAll();
	
	public Student save(Student student);
	
	public Iterable<Student> saveAll(Iterable<Student> entities);
	
	public void deleteById(Long id);
	
	public void delete(Student entity);
}
