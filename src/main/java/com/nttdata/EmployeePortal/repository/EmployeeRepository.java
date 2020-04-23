package com.nttdata.EmployeePortal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.nttdata.EmployeePortal.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	//@Query(value="select e.emp_id, e.first_name,e.last_name,e.email,e.phone_number,e.hire_date,e.job_id,e.salary from employee e where e.job_id=:jobId",nativeQuery = true)
	List<Employee> findByJobId( String jobId);
	
}
