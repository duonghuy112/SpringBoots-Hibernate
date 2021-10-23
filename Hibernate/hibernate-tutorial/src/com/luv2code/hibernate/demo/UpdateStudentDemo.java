package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		// create session factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// create session
		Session session = sessionFactory.getCurrentSession();
		
		// start transaction
		session.beginTransaction();
		
		int studentId = 1;
		
		Student s = session.get(Student.class, studentId);
		s.setFirstName("Duong Huy");
		
		// commit transaction
		session.getTransaction().commit();
		
		// NEW session
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		
		session.createQuery("update Student set email='foo@gmail.com' where id between 1 and 4").executeUpdate();
		
		session.getTransaction().commit();
		
		// close session
		sessionFactory.close();
		
	}

}
