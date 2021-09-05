package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
			
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
			
			//start the transaction 
			session.beginTransaction();
			
			//get the instructor detail object
			int ids = 24;
	
			InstructorDetail inst = session.get(InstructorDetail.class, ids);
			
			
			
			//print the instructor detail
			
			System.out.println("instructor detail: "+inst);
			//print the associate instructor
			
			System.out.println("getting instructor detail, from instructor detail class: "+inst.getInstructor());

			
			
			//delete the constructor
			
			
			//commit transaction 
			session.getTransaction().commit();
			
			
			
			System.out.println("done");
			
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			// TODO: handle finally clause
			session.close();
			factory.close();
		}
		
		
		
	}

}
