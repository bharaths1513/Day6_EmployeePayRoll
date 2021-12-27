package com.example.Demo.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class EmployeePayrollDTO {
	
	@NotEmpty(message="Employee name cannot be null")
	public String name;
	
	@Min(value = 500, message="min wage should be more than 500")
	public long salary;

	public EmployeePayrollDTO(String name, long salary) {
		super();this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "EmployeePayrollDTO [name=" + name + ", salary=" + salary + "]";
	}

}