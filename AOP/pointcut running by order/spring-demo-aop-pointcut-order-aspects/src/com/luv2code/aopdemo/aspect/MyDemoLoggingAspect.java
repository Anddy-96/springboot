package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	
	//this is where we add all of our related advices for logging
	//let's start with @before advice
	@Before("com.luv2code.aopdemo.aspect.MyAOPExpression.nogetset()")
	public void beforeAddAccount()
	{
		System.out.println(getClass() +": this is running before account method");
	}


	

}
