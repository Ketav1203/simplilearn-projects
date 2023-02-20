package org.LearnersAcademy.service;

import org.LearnersAcademy.entities.Teacher;

public interface TeacherService {
	void addTeacher(Teacher teacher);
	Teacher getTeacher(String name);
}
