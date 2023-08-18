package com.boot.web.service;

import java.util.List;

import com.boot.web.entities.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	
	Employee saveEmployee(Employee employee);
	
	void deleteEmployeeById(int id);
	
	
	Employee updateEmployee(Employee employee);
	Employee getEmployeeById(int id);
	
	List<Employee> searchEmoployee(String query);
}
