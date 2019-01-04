package com.springBootcrud.HibernateSpringBoot.DAO;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springBootcrud.HibernateSpringBoot.Model.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO 
{
	@Autowired
	private EntityManager entityManager; //inject session factory to get current session.

	@Override
	public List<Employee> get()
	{
		Session currentSession = entityManager.unwrap(Session.class);
		//this Employee is nothing but model class name
		Query<Employee> query = currentSession.createQuery("from Employee",Employee.class);
		List<Employee> list = query.getResultList();
		return list;
	}

	@Override
	public Employee get(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		return employee;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);//save as well as update it
	}

	@Override
	public void delete(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee employee = currentSession.get(Employee.class, id);
		currentSession.delete(employee);
	}
	
}
