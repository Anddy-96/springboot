package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
		
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
			
			
			//associate the object
		
			
			//start the transaction 
			session.beginTransaction();
			
			// get instructor by primary key id
			int ids = 1;
			
			Instructor ins = session.get(Instructor.class,ids);
			
			System.out.println("we found the instructor: "+ins);
			
			
			//delete the constructor
			if(ins != null)
			{
				System.out.println("deleting the object");
				
				//this will deldte the instructor detail table row also becz we hava cascade	
				session.delete(ins);
			}
			
			
			
			//commit transaction 
			session.getTransaction().commit();
			
			
			
			System.out.println("done");
			
			
		} finally {
			// TODO: handle finally clause
			
			factory.close();
		}
		
		
		
	}

}
