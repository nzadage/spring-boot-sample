package com.github.nzadage.spring.service;

import com.github.nzadage.spring.beans.Teacher;

public interface TeacherService {
	
	public Teacher findById(Long teacherId);
	
	public Iterable<Teacher> findAll();
	
	public Teacher save(Teacher teacher);
	
	public Iterable<Teacher> saveAll(Iterable<Teacher> entities);
	
	public void deleteById(Long id);
	
	public void delete(Teacher entity);
}
