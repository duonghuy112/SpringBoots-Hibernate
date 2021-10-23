package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		Session session = sessionFactory.getCurrentSession();
		
		session.beginTransaction();
		
		session.save(new Student("Le", "Ngan", "ngan@mail.com"));
		session.save(new Student("Phan", "Quuyen", "quyen@mgm.com"));
		session.save(new Student("Vo", "Quang", "Quang@mail.com"));
		
		session.getTransaction().commit();
		
		sessionFactory.close();
	}
}
