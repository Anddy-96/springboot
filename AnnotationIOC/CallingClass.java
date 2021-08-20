package com.luv2code.springdemopractise;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CallingClass {

	public static void main(String[] args) {
		
		
		// load context 
		
		ClassPathXmlApplicationContext cont = new ClassPathXmlApplicationContext("applicationContextpractise.xml");
		// getting  bean from storage
		Vehicle ob1 = cont.getBean("bike", Vehicle.class);
		//calling method on object
		
		System.out.println(ob1.run());
		
		// closing context
		cont.close();
		
	}

}
