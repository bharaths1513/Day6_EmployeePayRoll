package com.example.Demo.Repository;

//import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.Demo.model.EmployeePayrollData;


public interface EmployeePayrollRepository extends JpaRepository<EmployeePayrollData, Integer> {

//	@Query(value = "SELECT employee_id FROM employee_payroll WHERE email_id= :emailId AND password= :password", nativeQuery = true)
//	public int getUserDetails(String emailId, String password);
	
	
	public Optional<EmployeePayrollData> findByEmailId(String emailId);

//	public Optional<EmployeePayrollData> findByEmailId(String emailid, String password);



	

//	@Query(value="select * from employee_payroll, employee_department where employee_id = id and department = :department",nativeQuery = true)
//	List<EmployeePayrollData> findEmployeesByDepartments(String department);

	
}
