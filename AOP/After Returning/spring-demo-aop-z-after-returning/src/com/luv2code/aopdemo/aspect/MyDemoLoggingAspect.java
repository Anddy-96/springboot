package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	
	//method for @Afterretuning 
	@AfterReturning(pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))", returning = "result")
	public void afterRetuningcall(JoinPoint thejointpont, List<Account> result)
	{
		//print method
		String meth = thejointpont.getSignature().toShortString();
		System.out.println("\n========= Executing after return type :"+ meth);
		//print the result
		
		System.out.println("\n========= result is  :"+ result);
		
		//let's do some post-process the data
		
		//convert them to uppercase
		convertAccounttouppercase(result);
		
		System.out.println("\n========= result is  :"+ result);

		
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
		System.out.println(getClass() +": this is running before account method");
		
		//display the method sig 
		MethodSignature mesig = (MethodSignature) thejointpoint.getSignature();
		System.out.println("this is method signature :" + mesig );
		
		//display method param
		
		//get the args
		Object[] arg = thejointpoint.getArgs();
		//loop them to print
		for(Object tempargs : arg)
		{
			System.out.println(tempargs);
			
			if(tempargs instanceof Account)
			{
				Account theaccount = (Account) tempargs;
				System.out.println("accout name is :"+ theaccount.getName());

				System.out.println("accout level is :"+ theaccount.getLevel());
			}
		}
		
	}


	

}
