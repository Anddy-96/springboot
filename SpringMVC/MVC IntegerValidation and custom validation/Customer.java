package com.luv2code.springdemo.mvc;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Customer {

	
	private String firstName;
	
	
	@NotNull(message = "is required")
	@Min(value = 0, message = "must be greater than or equal to 0")
	@Max(value = 10,message = "must be smaller than or equal to 10")
	private Integer freePass;
	
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 char/digits")
	private String postalCode;
	
	@NotNull(message = "is required")
	@Size(min=1,message = "is required")
	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getFreePass() {
		return freePass;
	}

	public void setFreePass(Integer freePass) {
		this.freePass = freePass;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	
}
