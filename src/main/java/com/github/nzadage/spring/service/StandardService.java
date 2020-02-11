package com.github.nzadage.spring.service;

import com.github.nzadage.spring.beans.Standard;

public interface StandardService {

	public Standard findById(Long standardId);
	
	public Iterable<Standard> findAll();
	
	public Standard save(Standard standard);
	
	public Iterable<Standard> saveAll(Iterable<Standard> entities);
	
	public void deleteById(Long id);
	
	public void delete(Standard entity);
}
