package com.training.studentservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
//@AllArgsConstructor
@Entity
//@Table(name="STUD")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long studId;
	private String studName;
	private int age;
	
	@Column(name="stud_grade")
	private String grade;

	public Student(String studName, int age, String grade) {
		super();
		this.studName = studName;
		this.age = age;
		this.grade = grade;
	}
	
	

}
