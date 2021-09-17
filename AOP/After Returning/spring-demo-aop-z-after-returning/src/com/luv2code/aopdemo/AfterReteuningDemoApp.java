package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class AfterReteuningDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//read spring config class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from the spring container
		
		AccountDAO theAccount = context.getBean("accountDAO", AccountDAO.class);
		
		//call the method to find account
		
		List<Account> theacc = theAccount.findAccount();
		
		System.out.println("\n\n main after returnining");
		System.out.println("---------");
		
		System.out.println(theacc);
		
		System.out.println("\n");
		//close the context
		context.close();
		
		
	}

}
