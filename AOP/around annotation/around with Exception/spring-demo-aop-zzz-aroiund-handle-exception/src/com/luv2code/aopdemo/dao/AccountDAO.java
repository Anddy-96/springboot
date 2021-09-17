package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.cache.annotation.AbstractCachingConfiguration;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String dash;
	
	private String mash;
	
	public void addAccount(Account theaccount, boolean vip)
	{
		System.out.println(getClass() + ": Doing my DB work here");
	}
	
	public boolean docheck()
	{
		
		System.out.println("this is from boolean do check method under AccountDAO");
		return true;
	}

	public String getDash() {
		System.out.println(getClass()+": in getdash");
		return dash;
	}

	public void setDash(String dash) {

		System.out.println(getClass()+": in setdash");
		this.dash = dash;
	}

	public String getMash() {

		System.out.println(getClass()+": in getmash");
		return mash;
	}

	public void setMash(String mash) {

		System.out.println(getClass()+": in setmash");
		this.mash = mash;
	}
	//add a new method 
	public List<Account> findAccount(Boolean check)
	{
		List<Account> myacc = new ArrayList<>();
		
		//cheking exection
		if(check)
		{
			throw new RuntimeException("we throwed an exception becza check is made true");
		}
		
		
		//create sample account
		
		Account tem = new Account("Jhonwns", "Bronze");
		
		Account temp = new Account("tes", "silver");
		
		Account tempo = new Account("wewns", "platinum");
		//add them to list
		
		myacc.add(tempo);
		myacc.add(temp);
		myacc.add(tem);
		
		
		return myacc;
	}
	
	
	
}
