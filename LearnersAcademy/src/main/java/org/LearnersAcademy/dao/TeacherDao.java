package org.LearnersAcademy.dao;

import java.util.List;

import org.LearnersAcademy.entities.Teacher;


public interface TeacherDao {
	void insert(Teacher teacher);
	List<Teacher> getAll();
	Teacher get(String name);
	Teacher get(int tid);
	void delete(Teacher teacher);
	void update(Teacher teacher);
}
