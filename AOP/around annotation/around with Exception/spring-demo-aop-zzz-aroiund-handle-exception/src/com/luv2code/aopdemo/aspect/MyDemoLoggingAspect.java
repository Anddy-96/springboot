package com.luv2code.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger mylogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object aroundgetfortunre(ProceedingJoinPoint thejointpoint) throws Throwable
	{
		String meth = thejointpoint.getSignature().toShortString();
		mylogger.info("\n=========>> Executing around method :"+ meth);
		
		long begin = System.currentTimeMillis();
		
		Object result = null;
		
		try {
			result = thejointpoint.proceed();
		} catch (Throwable e) {
		
			mylogger.warning(e.getMessage());
			
			result = "the exception is taken care in Around advice";
			
			
		}
		
		long end = System.currentTimeMillis();
		
		long duration = end - begin;
		
		mylogger.info("\nthe time it take to run the method :"+duration/1000);
		
		return result;
	}
	
	//method for after method
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinallyadvice(JoinPoint thejointpoint)
	{
		//print method
		String meth = thejointpoint.getSignature().toShortString();
		mylogger.info("\n=========>> Executing after after finally method :"+ meth);
	}
	
	//method for @AFTER THROWING 
	@AfterThrowing(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", throwing = "exce")
	public void afterthrowingexection(JoinPoint thejointpoint, Throwable exce)
	{
		//print method
				String meth = thejointpoint.getSignature().toShortString();
				mylogger.info("\n=========>> Executing after throwing ecxeption type :"+ meth);
				//print the result
				
				mylogger.info("\n=========>> the exception is  :"+ exce);
		
	}
	
	//method for @Afterretuning 
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", returning = "result")
	public void afterRetuningcall(JoinPoint thejointpont, List<Account> result)
	{
		//print method
		String meth = thejointpont.getSignature().toShortString();
		mylogger.info("\n========= Executing after return type :"+ meth);
		//print the result
		
		mylogger.info("\n========= result is  :"+ result);
		
		//let's do some post-process the data
		
		//convert them to uppercase
		convertAccounttouppercase(result);
		
		mylogger.info("\n========= result is  :"+ result);

		
	}
	
	private void convertAccounttouppercase(List<Account> result) {
	
		
		//loop throw all and  update the name
		for(Account accounttemp:result)
		{
			String uppername = accounttemp.getName().toUpperCase();
			
			
			accounttemp.setName(uppername);
		}
		
	}

	//this is where we add all of our related advices for logging
	//let's start with @before advice
	@Before("com.luv2code.aopdemo.aspect.MyAOPExpression.nogetset()")
	public void beforeAddAccount(JoinPoint thejointpoint)
	{
		mylogger.info(getClass() +": this is running before account method");
		
		//display the method sig 
		MethodSignature mesig = (MethodSignature) thejointpoint.getSignature();
		mylogger.info("this is method signature :" + mesig );
		
		//display method param
		
		//get the args
		Object[] arg = thejointpoint.getArgs();
		//loop them to print
		for(Object tempargs : arg)
		{
			mylogger.info(tempargs.toString());
			
			if(tempargs instanceof Account)
			{
				Account theaccount = (Account) tempargs;
				mylogger.info("accout name is :"+ theaccount.getName());

				mylogger.info("accout level is :"+ theaccount.getLevel());
			}
		}
		
	}


	

}
