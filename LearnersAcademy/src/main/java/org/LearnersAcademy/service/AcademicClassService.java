package org.LearnersAcademy.service;


import org.LearnersAcademy.entities.AcademicClass;

public interface AcademicClassService {
	void addAcademicClass(AcademicClass academicClass);
	AcademicClass getAcademicClass(String semester);
}
