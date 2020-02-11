package com.github.nzadage.spring.beans;


import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@DiscriminatorValue("teacher")
public class Teacher extends Staff{
	
	@OneToOne(mappedBy = "classTeacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "classTeacher")
	private Standard classId;

	public Standard getClassId() {
		return classId;
	}

	public void setClassId(Standard classId) {
		this.classId = classId;
	}
	
}
