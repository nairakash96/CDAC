package com.ehospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehospital.customexception.InvalidLoginException;
import com.ehospital.dto.LoginRequest;
import com.ehospital.dto.LoginResponse;
import com.ehospital.pojos.HospitalEmployee;
import com.ehospital.service.IEmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/login")
public class GenericController {

	@Autowired
	private IEmployeeService employeeSevice;

	@Autowired
	private LoginResponse response;

	public GenericController() {
		System.out.println("in GenericController " + getClass().getName());
	}

	@PostMapping
	public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest request) {

		HospitalEmployee emp = employeeSevice.authenticateUser(request.getEmail(), request.getPassword());
	//	System.out.println(emp);
		if (emp != null) {
			response.setMessage("Welcome to eHospital " + emp.getName());
			response.setRole(emp.getRole());
		} else if (employeeSevice.checkForEmployee(request.getEmail()))
			throw new InvalidLoginException( "Invalid Credentials");
		else if (!employeeSevice.checkForEmployee(request.getEmail()))
			throw new InvalidLoginException("No Such User Exist!");

		return new ResponseEntity<>(response, HttpStatus.OK);

	}

}
