package com.example.Demo.service;

import java.util.List;


import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.Demo.Repository.EmployeePayrollRepository;
import com.example.Demo.dto.EmployeePayrollDTO;
import com.example.Demo.dto.LoginDTO;
import com.example.Demo.dto.ResponseDTO;
import com.example.Demo.dto.response;
import com.example.Demo.exception.EmployeePayrollException;
import com.example.Demo.model.EmployeePayrollData;
import com.example.Demo.utility.TokenUtil;



@Service
class EmployeePayrollService implements IEmploeePayrollService {

	@Autowired
	private EmployeePayrollRepository empRepo;

	
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private TokenUtil tokenutil;
	
	@Autowired
	ModelMapper modelmapper;

	
	
	@Override
	public List<EmployeePayrollData> getallAllEmployee() {
		//int employeeId = tokenutil.decodeToken();
		//Optional<EmployeePayrollData> isContactPresent = employeePayrollRepository.findById(employeeId);
//		if (isContactPresent.isPresent()) {
//			List<EmployeePayrollData> getallcontacts = employeePayrollRepository.findAll();
//			return getallcontacts;
//		} else {
//			throw new EmployeePayrollException(400, "Token is not valid!!");
//		}
		return empRepo.findAll();
	}
	@Override
	public EmployeePayrollData getEmployeePayrollDataById( int employeeId) {
//		int id = tokenutil.decodeToken(token);
		Optional<EmployeePayrollData> isEmployeePresent = empRepo.findById(employeeId);
		if (isEmployeePresent.isPresent()) {
			return empRepo.findById(employeeId)
					.orElseThrow(() -> new EmployeePayrollException("employee ID Not Found"));
		} else
			throw new EmployeePayrollException("Not Valid Token");
	}

//	@Override
//	public EmployeePayrollData createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
//		EmployeePayrollData empData = null;
//		empData = new EmployeePayrollData(empPayrollDTO);
//		log.debug("Employee Data: " + empData.toString());
//		return employeePayrollRepository.save(empData);
//	}
	public ResponseDTO createEmployeePayrollData(EmployeePayrollDTO empPayrollDTO) {
		Optional<EmployeePayrollData> isPresent = empRepo.findByEmailId(empPayrollDTO.getEmailId());
		if (isPresent.isPresent()) {
			throw new EmployeePayrollException( "Contact Already Added");
		} else {
			EmployeePayrollData contact = modelmapper.map(empPayrollDTO, EmployeePayrollData.class);
			empRepo.save(contact);
			String token = tokenutil.createToken(contact.getEmployeeId());
			return new ResponseDTO( "Contact Succefully Added", token);
		}

	}

	@Override
	public ResponseDTO updateEmployeePayrollData(int employeeId, EmployeePayrollDTO empPayrollDTO) {
		EmployeePayrollData empData = this.getEmployeePayrollDataById(employeeId);
//		int id = tokenutil.decodeToken(token);
		Optional<EmployeePayrollData> isEmployeePresent = empRepo.findById(employeeId);
		if (isEmployeePresent.isPresent()) {
			empData.updateEmployeePayollData(empPayrollDTO);
			empRepo.save(isEmployeePresent.get());
			return new ResponseDTO("Contact Succefully Updated", empData);
		} else {
			throw new EmployeePayrollException( "Token is not valid!!");
		}

	}

	@Override
	public ResponseDTO deleteEmployeeData(int employeeId) {
		//int employeeId = tokenutil.decodeToken(token);
		Optional<EmployeePayrollData> isContactPresent = empRepo.findById(employeeId);
		if (isContactPresent.isPresent()) {
			empRepo.delete(isContactPresent.get());
			return new ResponseDTO( "Contact Succefully deleted",employeeId);

		} else {
			throw new EmployeePayrollException( "Contact is not preset!!");
		}
	}

//	@Override
//	public List<EmployeePayrollData> getEmployeesByDepartments(String department) {
//		
//		return empRepo.findEmployeesByDepartments(department);
//	}

	

//	@Override
//	public LoginData createLoginData(LoginDTO logindto) {
//		LoginData loginData = new LoginData(logindto);
//		return loginRepository.save(loginData);
//	}
//
	@Override
	public response loginValidation(LoginDTO loginDTO) {
		String token;
		Optional<EmployeePayrollData> isPresent = empRepo.findByEmailId(loginDTO.getEmailid());
		if (isPresent.isPresent()) {
			String pass = isPresent.get().getPassword();
			if (pass.equals(loginDTO.getPassword())) {
				// long empId = employeeRepository.getUserDetails(loginDTO.getEmailId(),
				// loginDTO.getPassword());
				token = tokenutil.createToken(isPresent.get().getEmployeeId());
				return new response(token);
			} else {
				throw new EmployeePayrollException( "Password is Wrong");
			}
		} else {
			throw new EmployeePayrollException( "Email ID or password is wrong");
		}
	}

	

}