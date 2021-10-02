package com.luv2code.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.luv2code.springboot.cruddemo.entity.Employee;
@Repository
public class EmployeeDAOjpaImpl implements EmployeeDAO {

	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDAOjpaImpl(EntityManager theentityManager)
	{
		entityManager = theentityManager;
	}
	
	@Override
	public List<Employee> findAll() {
		
		Query theQuery = entityManager.createQuery("from Employee");
		
		List<Employee> theemp = theQuery.getResultList();
		
		return theemp;
	}

	@Override
	public Employee findById(int id) {
		
		Employee theempl = entityManager.find(Employee.class, id);
		
		return theempl;
	}

	@Override
	public void saveEmployee(Employee theEmpeloyee) {
		
		Employee dbEmpl = entityManager.merge(theEmpeloyee);
		
		//we have to update the new id which was passed - so that it is visible at frontend or output
		theEmpeloyee.setId(dbEmpl.getId());

	}

	@Override
	public void deleteEmployeeById(int theid) {
	
		
		Query thequ = entityManager.createQuery("delete from Employee where id =:employeeid");
		thequ.setParameter("employeeid", theid);
		thequ.executeUpdate();

	}

}
