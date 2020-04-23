package com.nttdata.EmployeePortal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.EmployeePortal.Service.EmployeeService;
import com.nttdata.EmployeePortal.model.Employee;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	/* Post */
	@PostMapping(value  = "/employee")
	public void addEmployee( @RequestBody Employee employee) {
		
		employeeService.addEmployee(employee);
	} 
	
	/* Get */
	
	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployee(){
		
		return employeeService.getAllEmployess();
	}
	/* Put */
	
	@RequestMapping(method = RequestMethod.PUT, value = "/updateEmployee")
	public void updateEmployee(@RequestBody Employee employee) {
	
		employeeService.updateEmployee(employee);
	}
	
	/* Delete */
	@RequestMapping(method = RequestMethod.DELETE, value = "/employees/{id}")
	public void deleteEmployee(@PathVariable String id) {
		employeeService.deleteEmployee(Long.parseLong(id));
	}
	
	@GetMapping(value = "/employees/{jobId}")
	public List<Employee> getEmployeesByJobId(@PathVariable String jobId){
		return employeeService.getEmpByJobId(jobId);
	}
	
	@PostMapping(value = "employees")
	public void addEmployees(@RequestBody List<Employee> employees) {
		
	}
	
}
