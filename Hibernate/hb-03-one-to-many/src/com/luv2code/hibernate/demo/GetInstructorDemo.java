package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class GetInstructorDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Instructor instructor = session.get(Instructor.class, 1);
		System.out.println(instructor);
		
		instructor.getCourses().forEach(System.out::println);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
