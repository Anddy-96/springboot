package com.luv2code.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
	
	private String firstname;
	private String lastname;
	
	private String country;
	
	private LinkedHashMap<String, String> options;
	private String favlan;
	
	private String[] opsy;
	
	
	public Student()
	{
		options = new LinkedHashMap<String, String>();
		
		options.put("IN","India");
		options.put("DE", "Germany");
		options.put("UK", "UK");
		options.put("USA", "USA");
		
		
	}


	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public LinkedHashMap<String, String> getOptions() {
		return options;
	}


	public String getFavlan() {
		return favlan;
	}


	public void setFavlan(String favlan) {
		this.favlan = favlan;
	}


	public String[] getOpsy() {
		return opsy;
	}


	public void setOpsy(String[] opsy) {
		this.opsy = opsy;
	}

	

	
	
	

}
