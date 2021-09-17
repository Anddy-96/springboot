package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//read spring config class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from the spring container
		
		TrafficFortuneService thefortune = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		//call the method to find account
		
		System.out.println("in main program Arounddemoapp");
		
		System.out.println("calling fortune service funciton");
		
		String data = thefortune.getFortune();
		
		System.out.println("\n the fortune is :"+data);
		
		System.out.println("finished");
		
		System.out.println("\n");
		//close the context
		context.close();
		
		
	}

}
