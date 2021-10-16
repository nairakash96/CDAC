package com.ehospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ehospital.customexception.InvalidLoginException;
import com.ehospital.dto.AppointmentDetailsPatient;
import com.ehospital.dto.LoginRequest;
import com.ehospital.dto.PatientResponse;
import com.ehospital.pojos.Patient;
import com.ehospital.service.IAppointmentService;
import com.ehospital.service.IPatientService;

@RestController
@CrossOrigin

public class PatientLoginController {

	@Autowired
	private IPatientService patientSevice;
	
	@Autowired
	private IAppointmentService appointmentService;


	public PatientLoginController() {
		System.out.println("in Patient Login Controller " + getClass().getName());
	}

	@PostMapping("/patientlogin")
	public ResponseEntity<?> authenticatePatient(@RequestBody LoginRequest request) {

		PatientResponse response=new PatientResponse();
		Patient patient = patientSevice.authenticatePatient(request.getEmail(), request.getPassword());
		System.out.println(patient);
		if (patient != null) {
			System.out.println("Inside If");
			response.setMessage("Welcome to eHospital " + patient.getPatientName());
			response.setId(patient.getId());
		} else if (patientSevice.checkForPatient(request.getEmail()))
			throw new InvalidLoginException( "Invalid Credentials");
		else if (!patientSevice.checkForPatient(request.getEmail()))
			throw new InvalidLoginException("No Such User Exist!");
		System.out.println("outside side If");
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	

	
	@GetMapping(value = "/appointment/{pid}")
	public ResponseEntity<?> listAppointments(@PathVariable Integer pid) {

		List<AppointmentDetailsPatient> response=appointmentService.listAppointments(pid);
		System.out.println("in  Patient Controller");
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}


}
