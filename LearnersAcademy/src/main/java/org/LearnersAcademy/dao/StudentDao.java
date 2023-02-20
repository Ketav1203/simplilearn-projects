package org.LearnersAcademy.dao;

import java.util.List;

import org.LearnersAcademy.entities.Student;


public interface StudentDao {
	void insert(Student student);
	List<Student> getAll();
	Student get(int stuId);
	void delete(Student student);
	void update(Student student);
}
