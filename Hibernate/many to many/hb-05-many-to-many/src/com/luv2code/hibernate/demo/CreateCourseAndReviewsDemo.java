package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Review;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).buildSessionFactory();
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
	
			//start the transaction 
			session.beginTransaction();
			// create the course 
			Course tempc = new Course("IP class - The IP class for 11th student");
			
			
			
			//add some reviews 
			tempc.add(new Review("best class loved it.."));
			tempc.add(new Review("Amazing.."));
			tempc.add(new Review("loved it.."));
			tempc.add(new Review("bestest.."));
			
			
			//save the course 
			System.out.println("saving the course ");
			
			System.out.println(tempc);
			System.out.println(tempc.getReviews());
			session.save(tempc);
			
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
