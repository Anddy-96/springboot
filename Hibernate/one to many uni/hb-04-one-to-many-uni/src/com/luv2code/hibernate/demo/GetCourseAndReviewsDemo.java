package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
	
			//start the transaction 
			session.beginTransaction();
			
			int id = 10;
			
			Course tmepc = session.get(Course.class, id);
			
			
			//print
			System.out.println(tmepc);
			
			//printing reviews 
			System.out.println(tmepc.getReviews());
			
			
			//commit transaction 
			session.getTransaction().commit();
			
			
			
			System.out.println("i'm done here");
			
			
		} finally {
			// TODO: handle finally clause
			session.close();
			factory.close();
		}
		
		
		
	}

}
