package com.luv2code.springboot.demo.myspringcoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	
	@GetMapping("/")
	public String sayHello()
	{
		return "Hello Worlds, the time on server is :"+LocalDateTime.now();
	}
	
}
