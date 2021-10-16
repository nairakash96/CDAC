package com.ehospital.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehospital.dto.AppointmentDTO;
import com.ehospital.dto.AppointmentDetailsDoctor;
import com.ehospital.dto.PatientResponse;
import com.ehospital.pojos.Appointment;
import com.ehospital.pojos.Patient;
import com.ehospital.pojos.TypeOfPatient;
import com.ehospital.service.IAppointmentService;
import com.ehospital.service.IPatientBedService;
import com.ehospital.service.IPatientService;

@RestController
@CrossOrigin
@RequestMapping("/patient")
public class ReceptionistController {

	@Autowired
	private IPatientService patientService;
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@Autowired
	private IPatientBedService patientBedService;
	

	@PostMapping
	public ResponseEntity<?> createPatient(@RequestBody Patient request) {
		Patient patient = patientService.createPatient(request.getPatientName(), request.getPatientEmail(),
				request.getPassword(), request.getPatientType(), request.getAge(), request.getGender(), 0.0);
		PatientResponse response = new PatientResponse(patient.getId(), "Patient Added Successfully!");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<?> getPatients() {
		List<Patient> patientList = new ArrayList<>();
		patientList = patientService.getAllPatientDetails();
		return new ResponseEntity<>(patientList, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<?> updatePatient(@RequestBody Patient request) {
		String messange="";
		if(request.getPatientType().equals(TypeOfPatient.IN))
		{
			Integer allocatedBedID=patientBedService.getBedIDByPatientID(request);
			patientBedService.deAllocateBedToPatient(allocatedBedID);
			 messange= patientService.updatePatientDetails(request.getId(), request.getPatientName(),
					request.getPatientEmail(), request.getPassword(), request.getPatientType(), request.getAge(),
					request.getGender(), request.getTotalBillAmount()+patientBedService.getBedBillAmount(patientService.getPatientById(request.getId())));
		}
		else
		{
		
			messange = patientService.updatePatientDetails(request.getId(), request.getPatientName(),
					request.getPatientEmail(), request.getPassword(), request.getPatientType(), request.getAge(),
					request.getGender(), request.getTotalBillAmount());
		}
		return new ResponseEntity<>(messange, HttpStatus.OK);
	}

	@GetMapping(value = "/{pid}")
	public ResponseEntity<?> getPatientById(@PathVariable Integer pid) {
		Patient patient = patientService.getPatientById(pid);
		return new ResponseEntity<>(patient, HttpStatus.OK);
	}

	@DeleteMapping("/{pid}")
	public ResponseEntity<?> deletePatient(@PathVariable Integer pid) {
		String message = patientService.deletePatient(pid);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}
	

	
	@PutMapping("/dischargePatient/{pid}")
	public ResponseEntity<String> dischargePatient(@PathVariable Integer pid)
	{
		System.out.println("In dischargePatient");
		Patient patient=patientService.getPatientById(pid);

		Integer allocatedBedID=patientBedService.getBedIDByPatientID(patient);
		System.out.println(allocatedBedID);
		System.out.println(patient);
		patientService.updatePatientDetails(patient.getId(), patient.getPatientName(), patient.getPatientEmail(), patient.getPassword(), TypeOfPatient.OUT, patient.getAge(), patient.getGender(), patient.getTotalBillAmount());
		return ResponseEntity.ok(patientBedService.deAllocateBedToPatient(allocatedBedID));
	
	}
	
	@PostMapping("/appointment")
	public ResponseEntity<?> bookAppointment(@RequestBody AppointmentDTO request) {
		System.out.println(request);

		Appointment appointment = appointmentService.bookAppointment(request.getPatientId(), request.getDoctorId(),
				 request.getDeptId(), request.getAppointmentDate(), request.getAppointmentTime());
		AppointmentDTO response = new AppointmentDTO(appointment.getAppointmentDate(),appointment.getAppointmentTime(),
				appointment.getDepartment().getId(),appointment.getPatient().getId(),
				appointment.getDoctor().getDoctorId());
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping(value = "/appointment/{did}")
	public ResponseEntity<?> listAppointments(@PathVariable Integer did) {

		List<AppointmentDetailsDoctor> response=appointmentService.listDoctorAppointments(did);
			
		return new ResponseEntity<>(response, HttpStatus.OK);
	}




}
