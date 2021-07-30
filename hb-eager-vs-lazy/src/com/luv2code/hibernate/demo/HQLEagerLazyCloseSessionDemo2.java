package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class HQLEagerLazyCloseSessionDemo2 {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		//option2: using HQL
		Query<Instructor> query = session.createQuery("select i from Instructor i " 
													+ "JOIN FETCH i.courses "
													+ "where i.id =: instructorId", 
													Instructor.class);
		query.setParameter("instructorId", 1);
		
		Instructor instructor = query.getSingleResult();
		
		session.getTransaction().commit();
		//close session
		session.close();
		
		System.out.println(instructor);
		instructor.getCourses().forEach(System.out::println);
		
		factory.close();
	}
}
