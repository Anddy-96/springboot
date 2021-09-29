package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRESTExceptionHandler {

	
	//add exception 
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc)
	{
		
		//create a studentError REesponse object
		
		StudentErrorResponse error = new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimestamp(System.currentTimeMillis());
		
		//return respomse
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	//generic excepiton handler
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc)
	{
		
		//create a studentError REesponse object
		
				StudentErrorResponse error = new StudentErrorResponse();
				error.setStatus(HttpStatus.BAD_REQUEST.value());
				error.setMessage(exc.getMessage());
				error.setTimestamp(System.currentTimeMillis());
				
				//return respomse
				
				return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
		
		
		
	}
	
	
	
}
