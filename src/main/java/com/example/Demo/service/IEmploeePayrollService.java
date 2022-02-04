 package com.example.Demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Demo.dto.EmployeePayrollDTO;
import com.example.Demo.dto.LoginDTO;
import com.example.Demo.dto.ResponseDTO;
import com.example.Demo.dto.response;
import com.example.Demo.model.EmployeePayrollData;



@Service
public interface IEmploeePayrollService {


	ResponseDTO createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	ResponseDTO deleteEmployeeData(int employeeId);

	EmployeePayrollData getEmployeePayrollDataById(int employeeId);

	ResponseDTO updateEmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO);

	List<EmployeePayrollData> getallAllEmployee();

//	LoginData createLoginData(LoginDTO logindto);
//
//	String generateToken(EmployeePayrollData loginData);

	response loginValidation(LoginDTO loginDTO);

	

	

	

}