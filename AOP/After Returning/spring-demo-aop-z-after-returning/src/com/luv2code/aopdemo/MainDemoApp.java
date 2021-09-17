package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		//read spring config class
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		//get the bean from the spring container
		
		AccountDAO theAccount = context.getBean("accountDAO", AccountDAO.class);
		
		//get the bean for membership class
		MembershipDAO themember = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		Account myAccount = new Account();
		myAccount.setLevel("golden");
		myAccount.setName("jhony");
		
		theAccount.addAccount(myAccount, false);
		
		theAccount.docheck();
		
		//for calling getter and setter
		theAccount.setDash("YEAH IT IS");
		theAccount.setMash("idk");
		
		String dash = theAccount.getDash();
		String mash = theAccount.getMash();
		
		
		
		themember.addsillyAccount();
		themember.dosomehthing();
		//close the context
		context.close();
		
		
	}

}
