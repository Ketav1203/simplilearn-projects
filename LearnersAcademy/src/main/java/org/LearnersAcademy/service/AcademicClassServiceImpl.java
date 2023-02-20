package org.LearnersAcademy.service;


import org.LearnersAcademy.dao.AcademicClassDao;
import org.LearnersAcademy.dao.AcademicClassDaoImpl;
import org.LearnersAcademy.entities.AcademicClass;

public class AcademicClassServiceImpl implements AcademicClassService{
	private AcademicClassDao dao=new AcademicClassDaoImpl();

	@Override
	public void addAcademicClass(AcademicClass academicClass) {
		dao.insert(academicClass);
	}

	@Override
	public AcademicClass getAcademicClass(String semester) {
		return dao.get(semester);
	}

	
}
