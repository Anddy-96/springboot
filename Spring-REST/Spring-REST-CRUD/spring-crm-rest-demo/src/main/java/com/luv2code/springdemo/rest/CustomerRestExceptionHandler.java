package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	
	//add an excpetion hadler for custoemr not found ecxeption
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleExceptio(CustomerNotFoundException exe)
	{
		
		//create object 
		CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.NOT_FOUND.value(),exe.getMessage(),System.currentTimeMillis());
		
		
		//return error
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	//exception for all
	
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleExceptio(Exception exe)
	{
		//create object 
				CustomerErrorResponse error = new CustomerErrorResponse(HttpStatus.BAD_REQUEST.value(),exe.getMessage(),System.currentTimeMillis());
				
				
				//return error
				return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
