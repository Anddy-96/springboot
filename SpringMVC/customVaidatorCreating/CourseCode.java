package com.luv2code.springdemo.mvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
	
	
	// define attributes course code
	public String value() default "SEE";
	
	//default error message
	public String message() default "must start with SEE";
	
	//default group
	public Class<?>[] groups() default {};
 	
	
	//default payload
	public Class<? extends Payload>[] payload() default {};
	
	
	
	
	

}
