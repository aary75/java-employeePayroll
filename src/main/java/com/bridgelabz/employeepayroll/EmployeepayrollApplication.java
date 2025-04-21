package com.bridgelabz.employeepayroll;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class EmployeepayrollApplication {

	private static final Logger log = LoggerFactory.getLogger(EmployeepayrollApplication.class);

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EmployeepayrollApplication.class, args);
	    log.info("Employee Payroll App Started",
				context.getEnvironment().getProperty("environment"));
	    log.info("Employee Payroll DB user is {} ",
				context.getEnvironment().getProperty("spring.datasource.username"));

	}

}
