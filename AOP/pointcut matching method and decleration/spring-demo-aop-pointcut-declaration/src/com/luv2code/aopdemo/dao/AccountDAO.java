package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	
	public void addAccount(Account theaccount, boolean vip)
	{
		System.out.println(getClass() + ": Doing my DB work here");
	}
	
	public boolean docheck()
	{
		
		System.out.println("this is from boolean do check method under AccountDAO");
		return true;
	}
}
