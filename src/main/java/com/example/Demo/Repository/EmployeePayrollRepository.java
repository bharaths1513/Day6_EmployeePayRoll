package com.example.Demo.Repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Demo.model.EmployeePayrollData;

public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

	@Query(value="select * from employee_payroll, employee_department where employee_id = id and department = :department",nativeQuery = true)
	List<EmployeePayrollData> findEmployeesByDepartments(String department);

//	@Query(value="select * from employee_payroll, employee_department where employee_id = id and department = :department",nativeQuery = true)
//	List<EmployeePayrollData> findEmployeesByDepartments(String department);

	
}
