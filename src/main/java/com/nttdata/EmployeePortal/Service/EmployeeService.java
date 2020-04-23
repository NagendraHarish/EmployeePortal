package com.nttdata.EmployeePortal.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.EmployeePortal.model.Employee;
import com.nttdata.EmployeePortal.properties.EmailProperties;
import com.nttdata.EmployeePortal.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private EmailProperties mailProperties;

	/* Get All Employees */
	public List<Employee> getAllEmployess() {
		List<Employee> employees = new ArrayList<>();
		employeeRepository.findAll().forEach(employees::add);
		return employees;
	}

	/* Add employee */
	public void addEmployee(Employee employee) {
		employeeRepository.save(employee);
	}
	
	/* Update Employee */
	public void updateEmployee(Employee employee) {

		employeeRepository.save(employee);
	}

	/* Delete Employee */
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}

	/* Get Employee by JobID */
	public List<Employee> getEmpByJobId(String id) {
		return employeeRepository.findByJobId(id);
	}
	
	public void displayEmailProperties() {
		System.out.println("Mail TO = " + mailProperties.getTo());
	    System.out.println("HOST = " + mailProperties.getHost());
	    System.out.println("PORT = " + mailProperties.getPort());
	    System.out.println();
	    
	    //Print list or array
	    System.out.println("Mail CC = " + String.join(", ", mailProperties.getCc()));
	    System.out.println("Mail BCC = " + mailProperties.getBcc());
	    System.out.println("Map ="+ mailProperties.getItems());
	    
	    //Print nested bean's properties
	    System.out.println("User Name = " + mailProperties.getCredential().getUserName());
	    System.out.println("Password = " + mailProperties.getCredential().getPassword());
	}
	
	
}
