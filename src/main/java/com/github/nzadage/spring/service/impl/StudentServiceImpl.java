package com.github.nzadage.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.nzadage.spring.beans.Student;
import com.github.nzadage.spring.repository.StudentRepository;
import com.github.nzadage.spring.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public Student findById(Long studentId) {
		return studentRepository.findById(studentId).get();
	}

	@Override
	public Iterable<Student> findAll() {
		return studentRepository.findAll();
	}

	@Override
	public Student save(Student entity) {
		return studentRepository.save(entity);
	}

	@Override
	public Iterable<Student> saveAll(Iterable<Student> entities) {
		return studentRepository.saveAll(entities);
	}

	@Override
	public void deleteById(Long id) {
		studentRepository.deleteById(id);
	}

	@Override
	public void delete(Student entity) {
		studentRepository.delete(entity);
	}

}
