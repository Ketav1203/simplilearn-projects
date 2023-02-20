package org.LearnersAcademy.dao;

import java.util.List;

import org.LearnersAcademy.config.HibConfig;
import org.LearnersAcademy.entities.Subject;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SubjectDaoImpl implements SubjectDao{
	@Override
	public void insert(Subject Subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(Subject);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Subject> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Subject> query=session.createQuery("select s from org.LearnersAcademy.entities.Subject s");
		return query.list();
	}

	@Override
	public void delete(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(subject);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void update(Subject subject) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(subject);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Subject get(int sid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Subject subject=session.get(Subject.class, sid);
		return subject;
	}
}
