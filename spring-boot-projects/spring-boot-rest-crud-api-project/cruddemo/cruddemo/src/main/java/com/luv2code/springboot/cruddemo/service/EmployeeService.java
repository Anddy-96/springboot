package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import com.luv2code.springboot.cruddemo.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int id);
	
	public void saveEmployee(Employee theEmpeloyee);
	
	public void deleteEmployeeById(int theid);
	

}
