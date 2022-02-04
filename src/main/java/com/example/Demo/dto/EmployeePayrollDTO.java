package com.example.Demo.dto;




import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.ToString;

@Data
public @ToString class EmployeePayrollDTO {
	
	public String emailId;
	public String password;
	@Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee Name is invalid")
	public String name;
	@Min(value = 500, message = "Min Wage should be more than 500")
	public long salary;
	@Pattern(regexp = "male|female", message = " Gender  needs to be male or female")
	public String gender;
//	@JsonFormat(pattern = "dd mm yyyy")
//	@NotNull(message = "Startdate should not be empty")
//	@PastOrPresent(message = "startDate shuld be past or todays date")
	public Date startDate;
	@NotBlank(message = "Note can not be empty")
	public String note;
	@NotBlank(message = "profilePic can not be empty")
	public String profilePic;
	@NotNull(message = "department should not be empty")
	public List<String> department;




}