package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	
	
	public void addsillyAccount()
	{
		System.out.println(getClass()+": doing my other DB work");
	}
	
	public void dosomehthing()
	{
		System.out.println("this is from dosomething method from MembershipDAO");
	}
}
