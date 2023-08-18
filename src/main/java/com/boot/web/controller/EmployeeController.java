package com.boot.web.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.boot.web.entities.Employee;
import com.boot.web.service.EmployeeService;

@Controller
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	
	@GetMapping("/")
	public String viewEmployee(Model model) {
		model.addAttribute("employees",employeeService.getAllEmployee());
		return "employee_list";
	}
	
	@GetMapping("/new")
	public String insertEmployee(Model model) {
		Employee employee=new Employee();
		model.addAttribute("employee",employee);
		return "Employee_form";
	}
	
	
	@PostMapping("/")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployee(@PathVariable int id, Model model) {
		model.addAttribute("employee",employeeService.getEmployeeById(id));
		return "employee_edit";
	}
	
	@PostMapping("/{id}")
	public String updateEmployee(@ModelAttribute("employee") Employee employee ) {
		employee.setName(employee.getName());
		employee.setEmail(employee.getEmail());
		employeeService.updateEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/";
		
	}
	
	@GetMapping("/search")
	public ResponseEntity<List<Employee>> searchEmployee(@RequestParam("query") String query) {
		return ResponseEntity.ok(employeeService.searchEmoployee(query));
		
	
	}
	
}
