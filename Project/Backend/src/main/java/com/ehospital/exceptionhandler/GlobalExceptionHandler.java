package com.ehospital.exceptionhandler;

import java.time.LocalDateTime;

import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ehospital.customexception.BedHandlingException;
import com.ehospital.customexception.InvalidLoginException;
import com.ehospital.customexception.MedicineHandlingException;
import com.ehospital.customexception.PatientHandlingException;
import com.ehospital.dto.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<?> handleDataIntegrityViolationException(DataIntegrityViolationException e)
	{
		System.out.println("In handleDataIntegrityViolationException"+e);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorResponse(e.getMessage(),LocalDateTime.now()));
	}
	
	
	
	@ExceptionHandler(MedicineHandlingException.class)
	public ResponseEntity<?> handleMedicineNotFoundException(MedicineHandlingException e)
	{
		System.out.println("In handleMedicineNotFoundException"+e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage(),LocalDateTime.now()));
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<?> handleEmptyResultDataAccessException(EmptyResultDataAccessException e)
	{
		System.out.println("In handleEmptyResultDataAccessException"+e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage(),LocalDateTime.now()));
	}
	
	@ExceptionHandler(BedHandlingException.class)
	public ResponseEntity<?> handleBedNotFoundException(BedHandlingException e)
	{
		System.out.println("In handleBedNotFoundException"+e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(e.getMessage(),LocalDateTime.now()));
	}
	@ExceptionHandler(InvalidLoginException.class)
	public ResponseEntity<?> handleInvalidLoginException(InvalidLoginException e)
	{
		ErrorResponse resp=new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	}
	
	@ExceptionHandler(PatientHandlingException.class)
	public ResponseEntity<?> handleUserHandlingException(PatientHandlingException e)
	{
		ErrorResponse resp=new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(resp);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e)
	{
		ErrorResponse resp=new ErrorResponse(e.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e)
	{
		ErrorResponse resp=new ErrorResponse("Constraint Violated", LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
	} 
}
