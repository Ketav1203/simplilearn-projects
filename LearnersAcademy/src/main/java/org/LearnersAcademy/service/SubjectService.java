package org.LearnersAcademy.service;

import java.util.List;

import org.LearnersAcademy.entities.Subject;


public interface SubjectService {
	void addSubject(Subject subject);
	List<Subject> getSubjects();
}
