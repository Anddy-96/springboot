package com.luv2code.aopdemo.dao;

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
	
	
	
}
