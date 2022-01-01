package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="semester_master")
public class Semester implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id",nullable=false,unique=true)
	private Long id;
	
	private Long totalMarksObtained;

	
	private Long semester;
	
	@Transient
	private Double percentage;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTotalMarksObtained() {
		return totalMarksObtained;
	}

	public void setTotalMarksObtained(Long totalMarksObtained) {
		this.totalMarksObtained = totalMarksObtained;
	}

	public Long getSemester() {
		return semester;
	}

	public void setSemester(Long semester) {
		this.semester = semester;
	}

	public Double getPercentage() {
		return (double) ((this.totalMarksObtained*100)/1000);
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	

	
	

}
