package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		// load the spring configuration  
		
		ClassPathXmlApplicationContext cont = new ClassPathXmlApplicationContext("beanscope-applicationContext.xml");
		
		//retrieve bean from container
		
		Coach c1 = cont.getBean("mycoach", Coach.class);
		
		Coach c2 = cont.getBean("mycoach", Coach.class);
		
		
		//checking are they pointing to same object
		Boolean b = (c1 == c2);
		
		System.out.println("pointing to same object refernece: "+b);
		//checking memory location 
		System.out.println("memory location of c1 :"+c1);
		System.out.println("memory location of c2 :"+c2);
		
		// closing context
		cont.close();
		
	}

}
