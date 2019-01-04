package com.springBootcrud.HibernateSpringBoot.Service;

import java.util.List;

import com.springBootcrud.HibernateSpringBoot.Model.Employee;

public interface EmployeeService 
{
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}
