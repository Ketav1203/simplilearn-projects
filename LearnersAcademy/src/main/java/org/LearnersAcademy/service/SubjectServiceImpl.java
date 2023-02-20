package org.LearnersAcademy.service;

import java.util.List;

import org.LearnersAcademy.dao.SubjectDao;
import org.LearnersAcademy.dao.SubjectDaoImpl;
import org.LearnersAcademy.entities.Subject;


public class SubjectServiceImpl implements SubjectService{
	private SubjectDao dao=new SubjectDaoImpl();
	@Override
	public void addSubject(Subject subject) {
		dao.insert(subject);
	}
	@Override
	public List<Subject> getSubjects() {
		return dao.getAll();
	}
	

}
