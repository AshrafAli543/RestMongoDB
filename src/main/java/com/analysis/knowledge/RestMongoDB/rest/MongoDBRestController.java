package com.analysis.knowledge.RestMongoDB.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.analysis.knowledge.RestMongoDB.entity.Employee;
import com.analysis.knowledge.RestMongoDB.model.EmployeeTO;
import com.analysis.knowledge.RestMongoDB.serviceImpl.EmployeeServiceImpl;


@RestController
@RequestMapping("/mongodb")
public class MongoDBRestController {
	
	@Autowired
	EmployeeServiceImpl employeeServiceImpl;
	
	@GetMapping("/base")
	public String getMethodName() {
		return "base method from MongoDBRestController";
	}
	
	@PostMapping("/employee-create")
	public String createEmployee(@RequestBody EmployeeTO employeeTO) {
		return employeeServiceImpl.createEmployee(employeeTO);
	}
	
	@GetMapping("/employees-read")
	public List<Employee> getAllEmployees(){
		return employeeServiceImpl.getAllEmployees();
	}
	
	@GetMapping("/employees-read-one")
	public Optional<Employee> getAllEmployees(@RequestParam String id){
		return employeeServiceImpl.getEmployeeById(id);
	}
	
	@PutMapping("/employee-update")
	public String updateEmployee(@RequestBody EmployeeTO employeeTO) {
		return employeeServiceImpl.updateEmployee(employeeTO);
	}
	
	@DeleteMapping("/employee-delete")
	public String deleteEmployee(@RequestParam String id) {
		return employeeServiceImpl.deleteEmployee(id);
	}

}
