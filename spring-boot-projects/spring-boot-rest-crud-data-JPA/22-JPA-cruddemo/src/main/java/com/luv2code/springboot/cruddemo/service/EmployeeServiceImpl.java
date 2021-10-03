package com.luv2code.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.luv2code.springboot.cruddemo.dao.EmployeeDAO;
import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;

@Service 
public class EmployeeServiceImpl implements EmployeeService {

	
	private EmployeeRepository employeeRepo;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theemployeeRepo)
	{
		employeeRepo = theemployeeRepo;
	}
	
	@Override
	
	public List<Employee> findAll() {
		
		return employeeRepo.findAll();
	}

	@Override
	
	public Employee findById(int id) {
		
		Optional<Employee> result = employeeRepo.findById(id);
		
		Employee theEmp = null;
		
		if(result.isPresent())
		{
			theEmp = result.get();
		}
		else
		{
			throw new RuntimeException("not found id :"+id);
		}
		return theEmp;
	}

	@Override
	
	public void saveEmployee(Employee theEmpeloyee) {
		
		employeeRepo.save(theEmpeloyee);
		
	}

	@Override
	
	public void deleteEmployeeById(int theid) {
		
		employeeRepo.deleteById(theid);
	}

}
