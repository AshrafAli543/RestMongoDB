package com.analysis.knowledge.RestMongoDB.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.analysis.knowledge.RestMongoDB.entity.Employee;
import com.analysis.knowledge.RestMongoDB.model.EmployeeTO;
import com.analysis.knowledge.RestMongoDB.repository.MongoDBEmployeeRepo;

@Service
public class EmployeeServiceImpl {

	@Autowired
	MongoDBEmployeeRepo mongoDBEmployeeRepo;
	
	public String createEmployee(EmployeeTO employeeTo) {
		String saveStatus="Employee Save In Progress";
		try {
			
			Employee employee = Employee.builder()
					.name(employeeTo.getName())
					.department(employeeTo.getDepartment())
					.salary(employeeTo.getSalary())
					.employmentStatus(employeeTo.getEmploymentStatus())
					.build();
			
			Employee savedEmployee = mongoDBEmployeeRepo.save(employee);
			if(!savedEmployee.getId().isEmpty()) {
				saveStatus = "Employee Saved Successfylly";
			}
			else
				saveStatus = "Employee Save not Successfull Need Triage";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return saveStatus;
	}
	
	public List<Employee> getAllEmployees(){
		List<Employee> employees = new ArrayList<Employee>();
		try {
			
			employees = mongoDBEmployeeRepo.findAll();
			System.out.println("Size--------"+employees.size());
			System.out.println("EMPLOYEES LIST -----------------------"+employees);
			
		} catch (Exception e) {
		System.out.println("Found an Exception to Check");
		}
		return employees;
	}
	
	public Optional<Employee> getEmployeeById(String id) {
		Optional<Employee> employee = Optional.of(new Employee());
		try {
			employee = mongoDBEmployeeRepo.findById(id);
		}catch (Exception e) {
			System.out.println(e);
		}
		return employee;
	}
	
	public String updateEmployee(EmployeeTO employeeTo) {
		String saveStatus="Employee update In Progress";
		try {
			
			Employee employee = Employee.builder()
					.id(employeeTo.getId())
					.name(employeeTo.getName())
					.department(employeeTo.getDepartment())
					.salary(employeeTo.getSalary())
					.employmentStatus(employeeTo.getEmploymentStatus())
					.build();
			
			Employee savedEmployee = mongoDBEmployeeRepo.save(employee);
			if(!savedEmployee.getId().isEmpty()) {
				saveStatus = "Employee updated Successfylly";
			}
			else
				saveStatus = "Employee update not Successfull Need Triage";
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return saveStatus;
	}

	public String deleteEmployee(String id) {
		String deleteStatus = "Delete In Progress";
		try {
			boolean searchId = false;
			Optional<Employee> searchEmployee = mongoDBEmployeeRepo.findById(id);
			if(searchEmployee.isPresent()) {
				mongoDBEmployeeRepo.deleteById(id);
				deleteStatus = "Employee Deleted Successfully";
			}
			else
				deleteStatus = "Unable to Delete Employee :No employee found by the provided ID";
			
		}catch (Exception e) {
			System.out.println();
			// TODO: handle exception
		}
		return deleteStatus;
	}

	
}
