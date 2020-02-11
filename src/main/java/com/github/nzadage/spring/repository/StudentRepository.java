package com.github.nzadage.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.github.nzadage.spring.beans.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	
}
