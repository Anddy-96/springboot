package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
			
			// use the java object to save the java object
			
			
			//create a student object
			System.out.println("creating the student object");
			
			Student tem = new Student("Debo","Lex","Debo@gmail.com");
			
			//start the transaction 
			session.beginTransaction();
			
			//save the student object
			System.out.println("saving the studnet data");
			System.out.println(tem);
			session.save(tem);
			
			//commit transaction 
			session.getTransaction().commit();
			
			// new code
			//find out the student ID 
			System.out.println("Saved student Generated ID: "+ tem.getId());
			
			
			// get a new session 
			
			
			//reterive student based on ID:
			session =  factory.getCurrentSession();
			session.beginTransaction();
			
			//commit the transaction
			System.out.println("\nGetting student with ID: "+tem.getId());
			
			Student mystud = session.get(Student.class, tem.getId()-4);
			
			System.out.println("Get complete data of student: "+mystud);
			
			
			//commit transaction
			session.getTransaction().commit();
			 
			
			
			System.out.println("done");
			
			
		} finally {
			// TODO: handle finally clause
			
			factory.close();
		}
		
		
		
	}

}
