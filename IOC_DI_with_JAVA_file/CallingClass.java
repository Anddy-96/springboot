package com.luv2code.springdemopractise;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CallingClass {

	public static void main(String[] args) {
		
		
		// load context from java file
		
		//ClassPathXmlApplicationContext cont = new ClassPathXmlApplicationContext("applicationContextpractise.xml");
		AnnotationConfigApplicationContext cont = new AnnotationConfigApplicationContext(TravelConfig.class);
		
		// getting  bean from storage
		Vehicle ob1 = cont.getBean("car", Vehicle.class);
		//calling method on object
		
		System.out.println(ob1.run());
		System.out.println(ob1.getTireBrand());
		
		// closing context
		cont.close();
		
	}

}
