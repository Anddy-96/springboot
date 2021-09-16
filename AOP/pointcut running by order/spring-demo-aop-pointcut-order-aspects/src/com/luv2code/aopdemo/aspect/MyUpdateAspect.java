package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(2)
public class MyUpdateAspect {
	
	
	@Before("com.luv2code.aopdemo.aspect.MyAOPExpression.nogetset()")
	public void beforeupdateAccount()
	{
		System.out.println(getClass() +": this is new update account");
	}

}
