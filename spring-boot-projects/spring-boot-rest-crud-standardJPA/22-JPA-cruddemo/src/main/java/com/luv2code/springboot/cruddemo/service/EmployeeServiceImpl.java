package com.luv2code.springboot.cruddemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service 
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeDAO employeeDAO;
	
	@Autowired
	public EmployeeServiceImpl(@Qualifier("employeeDAOjpaImpl")EmployeeDAO theemployeeDAO)
	{
		employeeDAO = theemployeeDAO;
	}
	
	@Override
	@Transactional
	public List<Employee> findAll() {
		
		return employeeDAO.findAll();
	}

	@Override
	@Transactional
	public Employee findById(int id) {
		
		return employeeDAO.findById(id);
	}

	@Override
	@Transactional
	public void saveEmployee(Employee theEmpeloyee) {
		
		employeeDAO.saveEmployee(theEmpeloyee);
		
	}

	@Override
	@Transactional
	public void deleteEmployeeById(int theid) {
		
		employeeDAO.deleteEmployeeById(theid);
	}

}
