package org.LearnersAcademy.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.LearnersAcademy.config.HibConfig;
import org.LearnersAcademy.entities.AcademicClass;

public class AcademicClassDaoImpl implements AcademicClassDao{
	@Override
	public void insert(AcademicClass academicClass) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(academicClass);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<AcademicClass> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<AcademicClass> query=session.createQuery("select a from org.LearnersAcademy.entities.AcademicClass a");
		return query.list();
	}

	@Override
	public void delete(AcademicClass academicClass) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(academicClass);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void update(AcademicClass academicClass) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(academicClass);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public AcademicClass get(String semester) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<AcademicClass> query=session.createQuery("select c from org.LearnersAcademy.entities.AcademicClass c where semester=?1");
		query.setParameter(1, semester);
		return query.getSingleResult();
	}
}
