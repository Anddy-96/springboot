package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//this is where we add all of our related advices for logging
	//let's start with @before advice
	@Before("execution(public void addAccount())")
	public void beforeAddAccount()
	{
		System.out.println(getClass() +": this is running before account method");
	}

	
	
	
	
	@Before("execution(public void updateAccount())")
	public void beforeupdateAccount()
	{
		System.out.println(getClass() +": this is running before update account method");
	}
}
