package com.project.Employeemanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.Employeemanagement.dao.EmployeeDao;
import com.project.Employeemanagement.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeDao empdao;
	
	@RequestMapping("/")
	public String Welcome() {
		return "Welcome to Employee Management";
	}
		
	
	@PostMapping("addEmployee")
	public Employee addEmployee(@RequestBody Employee pro) {
		return empdao.save(pro);	
	}
	@GetMapping("deleteEmployee/{employeeId}")
	public String deleteEmployeeById(@PathVariable int employeeId) {
		String result="";
		try{
			empdao.deleteById(employeeId);
			result = "all records deleted";
		}catch (Exception e) {
			result ="error occured";
		}
		return result;
	}
	
	@GetMapping("getAllEmployee")
	public List<Employee> getAllEmployee() {
		return empdao.findAll();
	}
	@GetMapping("getEmployee/{id}")
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		return empdao.findById(id);
	}
}
