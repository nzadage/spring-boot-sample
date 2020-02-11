package com.github.nzadage.spring.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.nzadage.spring.beans.Teacher;
import com.github.nzadage.spring.repository.TeacherRepository;
import com.github.nzadage.spring.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService{

	@Autowired
	private TeacherRepository teacherRepository;

	@Transactional
	public Teacher findById(Long teacherId) {
		return teacherRepository.findById(teacherId).get();
	}

	@Override
	@Transactional
	public Iterable<Teacher> findAll() {
		return teacherRepository.findAll();
	}

	@Override
	@Transactional
	public Teacher save(Teacher teacher) {
		return teacherRepository.save(teacher);
	}

	@Override
	@Transactional
	public Iterable<Teacher> saveAll(Iterable<Teacher> entities) {
		entities.forEach(a->{

		});
		return teacherRepository.saveAll(entities);
	}

	@Transactional
	@Override
	public void deleteById(Long id) {
		teacherRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void delete(Teacher entity) {
		teacherRepository.delete(entity);
	}

}
