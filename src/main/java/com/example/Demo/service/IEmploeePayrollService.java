package com.example.Demo.service;

import java.util.List;

import com.example.Demo.dto.EmployeePayrollDTO;
import com.example.Demo.model.EmployeePayrollData;


public interface IEmploeePayrollService {

	List<EmployeePayrollData> getEmployeePayrollData();

	EmployeePayrollData getEmployeePayrollDataById(int empId);

	EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO);

	EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO);

	void deleteEmployeePayrollData(int empId);

}