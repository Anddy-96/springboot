package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(3)
public class MySaveAspect {
	
	
	@Before("com.luv2code.aopdemo.aspect.MyAOPExpression.nogetset()")
	public void beforesaveaccount()
	{
		System.out.println(getClass() +": this is new save account");
	}

}
