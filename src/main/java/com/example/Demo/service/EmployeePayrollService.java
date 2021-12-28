package com.example.Demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Demo.Repository.EmployeePayrollRepository;
import com.example.Demo.dto.EmployeePayrollDTO;
import com.example.Demo.exception.EmployeePayrollException;
import com.example.Demo.model.EmployeePayrollData;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
class EmployeePayrollService implements IEmploeePayrollService {

	@Autowired
	private EmployeePayrollRepository empRepo;

	@Override
	public List<EmployeePayrollData> getEmployeePayrollData() {

		return empRepo.findAll();
	}

	@Override
	public EmployeePayrollData getEmployeePayrollDataById(int empId) {

		return empRepo.findById(empId).orElseThrow(
				() -> new EmployeePayrollException("Employee With EmployeeId " + empId + " Does not exists..!"));
	}

	@Override
	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = null;
		empData = new EmployeePayrollData(empPayrollDTO);
		log.debug("emp data: " + empData.toString());
		return empRepo.save(empData);
	}

	@Override
	public EmployeePayrollData updateEmployeePayrollData(int empId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empData.updateEmployeePayrollData(empPayrollDTO);
		return empRepo.save(empData);

	}

	@Override
	public void deleteEmployeePayrollData(int empId) {

		EmployeePayrollData empData = this.getEmployeePayrollDataById(empId);
		empRepo.delete(empData);
	}

	@Override
	public List<EmployeePayrollData> getEmployeesByDepartments(String department) {
		
		return empRepo.findEmployeesByDepartments(department);
	}

	

}