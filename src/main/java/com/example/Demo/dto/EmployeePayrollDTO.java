package com.example.Demo.dto;

import java.time.LocalDate;

import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.ToString;

public @ToString class EmployeePayrollDTO {
	
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\$]{2,}$",message = "name is Invalid")
	@NotEmpty(message="Employee name cannot be null")
	public String name;
	
	@Min(value = 500, message="min wage should be more than 500")
	public long salary;
	
	@Pattern(regexp = "male|female", message = "Gender needs to be male or female")
	public String gender;
	
	@JsonFormat(pattern="dd MMM yyyy")
	@NotNull(message = "Start Date Should Not be Empty")
	@PastOrPresent(message = "Start Date should be Past or Present")
	public LocalDate startDate;
	
	@NotBlank(message = "Note Cannot be Empty")
	public String note;
	
	@NotEmpty(message = "ProfilePic Cannot be empty")
	public String profilePic;
	
	@NotNull(message = "Department should not be empty")
	public List<String>departments;



}