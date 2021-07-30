package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Review;

public class CreateCourseAndReviewDemo {
	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		Course course = new Course("Football is the best");
		
		course.getReviews().add(new Review("Da tot vcl"));
		course.getReviews().add(new Review("Da do et"));
		
		session.save(course);
		
		session.getTransaction().commit();
		session.close();
		factory.close();
	}
}
