package com.github.nzadage.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.nzadage.spring.beans.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long>{

}
