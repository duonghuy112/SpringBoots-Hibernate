package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.luv2code.hibernate.entity.Course;
import com.luv2code.hibernate.entity.Instructor;
import com.luv2code.hibernate.entity.InstructorDetail;
import com.luv2code.hibernate.entity.Review;

public class GetCourseAndReviewDemo {
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
		
		Query<Course> query = session.createQuery("select c from Course c "
												+ "where c.id =: courseId", Course.class);
		query.setParameter("courseId", 10);
		
		Course course = query.getSingleResult();
		System.out.println(course);
		
		session.getTransaction().commit();
		session.close();
		
		course.getReviews().forEach(System.out::println);
		
		factory.close();
	}
}
