package com.luv2code.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService employeeService;
	
	//using cunstructor injection
	
	@Autowired
	public EmployeeRestController(EmployeeService themployeeservice)
	{
		employeeService = themployeeservice;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll()
	{	
		
		return employeeService.findAll();
	}
	
	//add a single employee
	@GetMapping("/employees/{employeeID}")
	public Employee getEmployee(@PathVariable int employeeID)
	{
		Employee theemp =  employeeService.findById(employeeID);
		
		if(theemp == null)
		{
			throw new RuntimeException("Employee ID not found :"+employeeID);
		}
		return theemp;
	}
	
	//adding new employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theemployee)
	{
		//they pass the ID in jason then set it 0 - this will make it insert new
		
		theemployee.setId(0);
		
		employeeService.saveEmployee(theemployee);
		
		return theemployee;
	}
	
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theemployee)
	{
		employeeService.saveEmployee(theemployee);
		
		return theemployee;
	}
	

	
	
	@DeleteMapping("/employees/{employeeID}")
	public String deleteEmployee(@PathVariable int employeeID)
	{
		Employee theemployee = employeeService.findById(employeeID);
		
		if(theemployee == null)
		{
			throw new RuntimeException("Employee Id not found :"+employeeID);
		}
		
		employeeService.deleteEmployeeById(employeeID);
		
		return "Deleted Employee ID :"+employeeID; 	
	}
	
}
