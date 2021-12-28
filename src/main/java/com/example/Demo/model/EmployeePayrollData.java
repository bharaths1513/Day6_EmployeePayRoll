package com.example.Demo.model;

import java.time.LocalDate;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.example.Demo.dto.EmployeePayrollDTO;

import lombok.Data;

@Entity
@Table(name="employee_payroll")
public @Data class EmployeePayrollData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="employee_Id")
	private int employeeId;
	
	@Column(name="name")
	private String name;
	private long salary;
	private String gender;
	private LocalDate startDate;
	private String note;
	private String profilePic;
	
	@ElementCollection
	@CollectionTable(name="employee_department",joinColumns = @JoinColumn(name = "id"))
	@Column(name="department")
	private List<String> departments;

	public EmployeePayrollData() {
	}
	

	public EmployeePayrollData( EmployeePayrollDTO empPayrollDTO) {

		
		this.name = empPayrollDTO.name;
		this.salary = empPayrollDTO.salary;
		this.gender = empPayrollDTO.gender;
		this.startDate = empPayrollDTO.startDate;
		this.note = empPayrollDTO.note;
		this.departments = empPayrollDTO.departments;
		this.profilePic = empPayrollDTO.profilePic;
	}


	public void updateEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		this.updateEmployeePayrollData(empPayrollDTO);
		
	}



}
