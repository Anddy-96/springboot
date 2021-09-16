package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	
	//pointcut we will use - this is like declare ones and use in anywhere you want
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void myFinal() {}	
	
	
	//create the point cut for getter and setter method 
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	public void setter() {}
	//create method to exclude the getter and setter from the mail run
	@Pointcut("myFinal() && !(getter() || setter())")
	private void nogetset() {}	
	
	//this is where we add all of our related advices for logging
	//let's start with @before advice
	@Before("nogetset()")
	public void beforeAddAccount()
	{
		System.out.println(getClass() +": this is running before account method");
	}

	
	@Before("nogetset()")
	public void beforeupdateAccount()
	{
		System.out.println(getClass() +": this is new API TestTING");
	}
}
