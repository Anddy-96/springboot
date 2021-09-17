package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAOPExpression {
	
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
		public void nogetset() {}	

}
