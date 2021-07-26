package com.luv2code.hibernate.demo;

import java.util.Arrays;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;

public class CreateCourseDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Instructor instructor = session.get(Instructor.class, 2);
		System.out.println(instructor);
		
		Course c1 = new Course("Tieng Anh");
		c1.setInstructor(instructor);
		
		Course c2 = new Course("Tieng Trung");
		c2.setInstructor(instructor);
		
		Course c3 = new Course("Tieng Thai");
		c3.setInstructor(instructor);
		
		instructor.setCourses(Arrays.asList(c1, c2, c3));
		
		session.save(c1);
		session.save(c2);
		session.save(c3);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
