package org.LearnersAcademy.dao;

import java.util.List;

import org.LearnersAcademy.entities.Subject;


public interface SubjectDao {
	void insert(Subject subject);
	List<Subject> getAll();
	Subject get(int sid);
	void delete(Subject subject);
	void update(Subject subject);
}
