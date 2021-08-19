package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

	public static void main(String[] args) {
		
		
		// load spring configuration
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanlifecycle-applicationContext.xml");
		
		// get bean from spring container 
		
		Coach obj = context.getBean("mycoach", Coach.class);
		
		// calling methods on object 
		
		System.out.println(obj.getDailyFortune());
		
		// closing context
		context.close();
	}

}
