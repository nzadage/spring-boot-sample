package com.github.nzadage.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.nzadage.spring.beans.Standard;
import com.github.nzadage.spring.beans.Teacher;
import com.github.nzadage.spring.repository.StandardRepository;
import com.github.nzadage.spring.service.StandardService;
import com.github.nzadage.spring.service.TeacherService;

@Service
public class StandardServiceImpl implements StandardService{
	
	@Autowired
	private StandardRepository standardRepository;
	
	@Autowired
	private TeacherService teacherService;
	
	@Transactional
	public Iterable<Standard> saveAll(Iterable<Standard> standards) {
		
		standards.forEach(action -> {
			if(null != action.getClassTeacher() && action.getClassTeacher().getId()>0){
				Teacher teacher = teacherService.findById(action.getClassTeacher().getId());
				action.setClassTeacher(teacher);
			}
		});
		
		Iterable<Standard> s =  standardRepository.saveAll(standards);
		return s;
	}

	@Override
	public Standard findById(Long standardId) {
		return standardRepository.findById(standardId).get();
	}

	@Override
	public Iterable<Standard> findAll() {
		return standardRepository.findAll();
	}

	@Override
	public Standard save(Standard entity) {
		return standardRepository.save(entity);
	}
	
	@Override
	public void deleteById(Long id) {
		standardRepository.deleteById(id);
	}
	
	@Override
	public void delete(Standard entity) {
		standardRepository.delete(entity);
	}

}
