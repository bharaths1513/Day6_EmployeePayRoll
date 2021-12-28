package com.example.Demo.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.Demo.dto.ResponseDTO;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class EmployeePayrollExceptionalHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException exception) {
		List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
		List<String> errMesg = errorList.stream().map(objErr -> objErr.getDefaultMessage())
				.collect(Collectors.toList());
		ResponseDTO responseDTO = new ResponseDTO("Exception While Processing REST Request", errMesg);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(EmployeePayrollException.class)
	public ResponseEntity<ResponseDTO> handleEmployeePayrollException(EmployeePayrollException exception){
		ResponseDTO responseDTO = new ResponseDTO("Exception While Processing REST Request", exception.getMessage());
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	public static final String message = "Exception Found";
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseDTO> handleHttpMessageNotReadableException(HttpMessageNotReadableException Exception){
		log.error("Invalid Date Format",Exception);
		ResponseDTO responseDTO = new ResponseDTO(message,"Should have data in the format dd MM yyyy");
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.BAD_REQUEST);
	}
	
}