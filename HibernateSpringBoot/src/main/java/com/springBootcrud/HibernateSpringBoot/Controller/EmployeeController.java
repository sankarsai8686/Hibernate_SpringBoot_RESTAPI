package com.springBootcrud.HibernateSpringBoot.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBootcrud.HibernateSpringBoot.Model.Employee;
import com.springBootcrud.HibernateSpringBoot.Service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeController 
{
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/employees")
	public List<Employee> get()
	{
		return employeeService.get();
	}
	
	@PostMapping("/save")
	public Employee save(@RequestBody Employee employee)
	{
		employeeService.save(employee);
		return employee;
	}
	
	@GetMapping("/employee/{id}")
	public Employee get(@PathVariable Integer id) 
	{
		Employee employee = employeeService.get(id);
		if(employee == null)
		{
			throw new RuntimeException("NOT PRESENT");
		}
		return employee;
	}
	
	@GetMapping("/delete/{id}")
	public void delete(@PathVariable Integer id)
	{
		//System.out.println("delete id : "+id);
		employeeService.delete(id);
	}
	
	@PutMapping("/update")
	public Employee update(@RequestBody Employee employee)
	{
		employeeService.save(employee);
		return employee;
	}
	
}
