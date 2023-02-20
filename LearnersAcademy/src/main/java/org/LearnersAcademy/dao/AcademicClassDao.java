package org.LearnersAcademy.dao;

import java.util.List;

import org.LearnersAcademy.entities.AcademicClass;

public interface AcademicClassDao {
	void insert(AcademicClass academicClass);
	List<AcademicClass> getAll();
	AcademicClass get(String semester);
	void delete(AcademicClass academicClass);
	void update(AcademicClass academicClass);
}
