package com.example.Demo.Controller;


import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Demo.dto.EmployeePayrollDTO;
import com.example.Demo.dto.LoginDTO;
import com.example.Demo.dto.ResponseDTO;
import com.example.Demo.dto.response;
import com.example.Demo.model.EmployeePayrollData;
//import com.example.Demo.model.LoginData;
import com.example.Demo.service.IEmploeePayrollService;


@CrossOrigin(allowedHeaders = "*", origins = "*")
@RestController
@RequestMapping("/employeePayrollservice")
/*
 * @RequestMapping:Used to set the class level URL.
 */
public class EmployeePayrollController {
	@Autowired
	private IEmploeePayrollService employeePayrollService;

	/*
	 * @RequestMapping:Used to take the URL for displaying message. return:message.
	 */
	@GetMapping("/getallcontact")
	ResponseEntity<List<?>> getallAllEmployee() {
		List<EmployeePayrollData> response = employeePayrollService.getallAllEmployee();
		return new ResponseEntity<List<?>>(response, HttpStatus.OK);
	}

	/*
	 * @PostMapping:used to pass the URL
	 * 
	 * @RequestBody:pass the object. return:created fields with the values.
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO) {
//		log.debug("Employee DTO:" + empPayrollDTO.toString());
		ResponseDTO empData = null;
		empData = employeePayrollService.createEmployeePayrollData(empPayrollDTO);
		ResponseDTO respDTO = new ResponseDTO( "Create Employee PayrollData:", empData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	/*
	 * @PutMapping:use to update the specified value. return:updated value.
	 */

	@PutMapping("/update/{employeeId}")
	public ResponseEntity<ResponseDTO> updateEmployeePayrollData(@Valid @RequestBody EmployeePayrollDTO empPayrollDTO,
			@PathVariable("employeeId") int employeeId) {
		ResponseDTO respDTO = employeePayrollService.updateEmployeePayrollData(employeeId,empPayrollDTO);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);

	}

	@DeleteMapping("/deletecontact/{employeeId}")
	ResponseEntity<ResponseDTO> deleteEmployeeData(@PathVariable("employeeId") int employeeId ) {
		ResponseDTO response = employeePayrollService.deleteEmployeeData(employeeId);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/get/{employeeId}")
	public ResponseEntity<ResponseDTO> getEmployeePayrollData(@PathVariable("employeeId") int employeeId) {
		EmployeePayrollData employeePayrollData = employeePayrollService.getEmployeePayrollDataById( employeeId);
		ResponseDTO respDTO = new ResponseDTO( "Get call for ID Successful:", employeePayrollData);
		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
	}
	
//	@GetMapping("/Getdepartment/{department}")
//	public ResponseEntity<ResponseDTO>getemployeedata(@PathVariable("department") String department){
//		List<EmployeePayrollData> empDatalist = null;
//		empDatalist = employeePayrollService.getEmployeesByDepartments(department);
//		ResponseDTO respDTO = new ResponseDTO("Get Call for Department Successful",empDatalist);
//		return new ResponseEntity<ResponseDTO>(respDTO,HttpStatus.OK);
//	}
	
//	@PostMapping("/Register")
//	public ResponseEntity<ResponseDTO> addLoginData(@RequestBody LoginDTO logindto) {
//		LoginData loginData = null;
//		loginData = employeePayrollService.createLoginData(logindto);
//		ResponseDTO respDTO = new ResponseDTO("Create Employee PayrollData:", loginData);
//		return new ResponseEntity<ResponseDTO>(respDTO, HttpStatus.OK);
//	}
	@PostMapping("/Login")
	public ResponseEntity<response> addUserRegistrationData(@RequestBody LoginDTO loginDTO) {
	    response Response = employeePayrollService.loginValidation(loginDTO);
//        log.debug("User Registration input detaisl: " + loginDTO.toString());
        return new ResponseEntity<response>(Response,HttpStatus.OK);
    }
}