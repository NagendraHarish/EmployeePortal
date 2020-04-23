package com.nttdata.EmployeePortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cglib.core.EmitUtils;
import org.springframework.context.ApplicationContext;

import com.nttdata.EmployeePortal.Service.EmployeeService;
import com.nttdata.EmployeePortal.properties.EmailProperties;

@SpringBootApplication
@EntityScan("com.nttdata.EmployeePortal.model")
@EnableConfigurationProperties(EmailProperties.class)
public class EmployeePortalApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(EmployeePortalApplication.class, args);

		EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

		employeeService.displayEmailProperties();
	}

}
