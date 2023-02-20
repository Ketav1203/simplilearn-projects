package org.LearnersAcademy.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stuId;
	private String name;
	private String address;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cid")
	private AcademicClass academicClass;
	public int getStuId() {
		return stuId;
	}
	public void setStuId(int stuId) {
		this.stuId = stuId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AcademicClass getAcademicClass() {
		return academicClass;
	}
	public void setAcademicClass(AcademicClass academicClass) {
		this.academicClass = academicClass;
	}
}

