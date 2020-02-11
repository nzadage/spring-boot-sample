package com.github.nzadage.spring.beans;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
public class Student implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4220756175066036555L;

	@Id
	@Column(name = "id", nullable = false, unique = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
//	@GeneratorType(type = Gen)
	private int id;
	
	@Column(name = "first_name",length = 100, nullable = false, unique = false)
	private String firstName;
	
	@Column(name = "last_name",length = 100, nullable = false, unique = false)
	private String lastName;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "class_id", nullable = false)
	private Standard classId;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Standard getClassId() {
		return classId;
	}
	public void setClassId(Standard classId) {
		this.classId = classId;
	}
}
