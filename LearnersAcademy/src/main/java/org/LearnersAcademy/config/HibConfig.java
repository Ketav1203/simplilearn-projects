package org.LearnersAcademy.config;

import java.util.Properties;

import org.LearnersAcademy.entities.AcademicClass;
import org.LearnersAcademy.entities.Student;
import org.LearnersAcademy.entities.Subject;
import org.LearnersAcademy.entities.Teacher;
import org.LearnersAcademy.entities.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibConfig {
	public static SessionFactory getSessionFactory() {
		Configuration configuration=new Configuration();
		Properties properties=new Properties();
		properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.put(Environment.URL, "jdbc:mysql://localhost:3306/testdb7");
		properties.put(Environment.USER, "root");
		properties.put(Environment.PASS, "root");
		properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
		properties.put(Environment.HBM2DDL_AUTO, "update");
		properties.put(Environment.SHOW_SQL, true);
		properties.put(Environment.FORMAT_SQL, true);
		configuration.setProperties(properties);
		configuration.addAnnotatedClass(Teacher.class);
		configuration.addAnnotatedClass(Student.class);
		configuration.addAnnotatedClass(AcademicClass.class);
		configuration.addAnnotatedClass(Subject.class);
		configuration.addAnnotatedClass(User.class);
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		return sessionFactory;
	}
}

