package org.LearnersAcademy.service;

import org.LearnersAcademy.dao.TeacherDao;
import org.LearnersAcademy.dao.TeacherDaoImpl;
import org.LearnersAcademy.entities.Teacher;

public class TeacherServiceImpl implements TeacherService{
	private TeacherDao dao=new TeacherDaoImpl();
	@Override
	public void addTeacher(Teacher teacher) {
		dao.insert(teacher);
	}
	@Override
	public Teacher getTeacher(String name) {
		return dao.get(name);
	}

}
