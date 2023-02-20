package org.LearnersAcademy.dao;

import java.util.List;

import org.LearnersAcademy.config.HibConfig;
import org.LearnersAcademy.entities.Teacher;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class TeacherDaoImpl implements TeacherDao{

	@Override
	public void insert(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(teacher);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public List<Teacher> getAll() {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Query<Teacher> query=session.createQuery("select t from org.LearnersAcademy.entities.Teacher t");
		session.close();
		return query.list();
	}

	@Override
	public void delete(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.delete(teacher);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void update(Teacher teacher) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Transaction tx=null;
		try {
			tx=session.beginTransaction();
			session.save(teacher);
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Teacher get(int tid) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		Teacher teacher=session.get(Teacher.class, tid);
		session.close();
		return teacher;
	}

	@Override
	public Teacher get(String name) {
		SessionFactory factory=HibConfig.getSessionFactory();
		Session session=factory.openSession();
		@SuppressWarnings("unchecked")
		Query<Teacher> query=session.createQuery("select t from org.LearnersAcademy.entities.Teacher t where name=?1");
		query.setParameter(1, name);
		
		return query.getSingleResult();
	}

}
