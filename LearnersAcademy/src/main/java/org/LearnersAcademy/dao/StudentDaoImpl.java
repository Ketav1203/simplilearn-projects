package org.LearnersAcademy.dao;

import java.util.List;

import org.LearnersAcademy.config.HibConfig;
import org.LearnersAcademy.entities.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class StudentDaoImpl implements StudentDao{
	@Override
	public void insert(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Student> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Student> query=session.createQuery("select s from org.LearnersAcademy.entities.Student s");
		return query.list();
	}

	@Override
	public void delete(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(student);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void update(Student student) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(student);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Student get(int stuId) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Student student=session.get(Student.class, stuId);
		return student;
	}
}
