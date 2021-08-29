package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;


import java.util.List;


public class QueryStudentDemo {

	
/*	public void display(List<Student> st)
	{
		for(Student stu : st)
		{
			System.out.println(stu);
		}
		
	}
	*/
	public static void main(String[] args) {
		
		
		
		// create session factory 
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		
		
		//create a session 
		
		Session session  = factory.getCurrentSession();
		
		
		try {
			
			//start the transaction 
			session.beginTransaction();
			
			//query student table
			List<Student> stud = session.createQuery("from Student").getResultList();
			
			//display the result
			display(stud);
			//query to get students with last name as 'LEX'
			
			stud = session.createQuery("from Student s where s.lastName = 'Lex'").getResultList();
			
			//display the students
			display(stud);
			
			//using or clause in SQL 
			
			stud = session.createQuery("from Student s where s.lastName ='Smith' OR s.firstName = 'Debo'").getResultList();
			display(stud);
			
			// ends with gmail.com
			stud = session.createQuery("from Student s where s.email LIKE '%@gmail.com'").getResultList();
			display(stud);
			
			//commit transaction 
			session.getTransaction().commit();
			
			System.out.println("done");
			
			
		} finally {
			// TODO: handle finally clause
			
			factory.close();
		}
		
		
		
	}

	private static void display(List<Student> stud) {
		for(Student stu : stud)
		{
			System.out.println(stu);
		}
	}

}
