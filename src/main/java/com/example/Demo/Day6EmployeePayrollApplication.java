package com.example.Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class Day6EmployeePayrollApplication {

	public static void main(String[] args) {
		SpringApplication.run(Day6EmployeePayrollApplication.class, args);
		log.info("Employee Payroll App Started");
	}

}
