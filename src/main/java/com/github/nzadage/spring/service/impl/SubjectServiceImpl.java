package com.github.nzadage.spring.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.nzadage.spring.beans.Standard;
import com.github.nzadage.spring.beans.Subject;
import com.github.nzadage.spring.repository.SubjectRepository;
import com.github.nzadage.spring.service.StandardService;
import com.github.nzadage.spring.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService{

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private StandardService standardService;

	public Subject findById(Long subjectId) {
		return subjectRepository.findById(subjectId).get();
	}

	public Iterable<Subject> findAll(){
		return subjectRepository.findAll();
	}

	@Override
	public Subject save(Subject subject) {
		return subjectRepository.save(subject);
	}

	@Override
	@Transactional
	public Iterable<Subject> saveAll(Iterable<Subject> entities) {
		entities.forEach(action -> {
			if(null != action && null != action.getClassId()&& action.getClassId().getId() > 0){
				action.setClassId(standardService.findById(action.getClassId().getId()));
			}else {
				Standard standard = action.getClassId();
				standardService.save(standard);
			}
		});
		return subjectRepository.saveAll(entities);
	}

	@Override
	public void deleteById(Long id) {
		subjectRepository.deleteById(id);
	}

	@Override
	public void delete(Subject entity) {
		subjectRepository.delete(entity);
	}

}
