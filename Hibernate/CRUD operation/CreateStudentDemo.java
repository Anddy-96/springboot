package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
			
			// use the java object to save the java object
			
			
			//create a student object
			System.out.println("creating the student object");
			
			Student tem = new Student("Bob","Smith","jhon@gmail.com");
			
			//start the transaction 
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the studnet data");
			session.save(tem);
			
			//commit transaction 
			session.getTransaction().commit();
			
			System.out.println("done");
			
			
		} finally {
			// TODO: handle finally clause
			
			factory.close();
		}
		
		
		
	}

}
