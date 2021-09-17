package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {
	
	private static Logger mylogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//read spring config class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from the spring container
		
		TrafficFortuneService thefortune = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		//call the method to find account
		
		mylogger.info("in main program Arounddemoapp");
		
		mylogger.info("calling fortune service funciton");
		
		String data = thefortune.getFortune();
		
		mylogger.info("\n the fortune is :"+data);
		
		mylogger.info("finished");
		
		mylogger.info("\n");
		//close the context
		context.close();
		
		
	}

}
