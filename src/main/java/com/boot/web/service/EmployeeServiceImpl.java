package com.boot.web.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.boot.web.entities.Employee;
import com.boot.web.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}
	
	
	private EmployeeRepository employeeRepository;
	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
		
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public void deleteEmployeeById(int id) {
		 employeeRepository.deleteById(id);;
	}
	@Override
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	@Override
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}
	@Override
	public List<Employee> searchEmoployee(String query) {
		
		return employeeRepository.findByName(query);
	}

	
}
