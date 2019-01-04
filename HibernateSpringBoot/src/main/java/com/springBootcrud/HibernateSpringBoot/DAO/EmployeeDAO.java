package com.springBootcrud.HibernateSpringBoot.DAO;

import java.util.List;

import com.springBootcrud.HibernateSpringBoot.Model.Employee;

public interface EmployeeDAO
{
	List<Employee> get();
	
	Employee get(int id);
	
	void save(Employee employee);
	
	void delete(int id);
}
