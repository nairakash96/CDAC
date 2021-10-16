package com.ehospital.service;

import java.time.LocalDate;
import java.util.List;

import com.ehospital.pojos.Appointment;
import com.ehospital.pojos.Patient;
import com.ehospital.pojos.TypeOfPatient;

public interface IPatientService {

	Patient createPatient(String patientName, String patientEmail, String password, TypeOfPatient patientType,
			Integer age, String gender, double bill);

	List<Patient> getAllPatientDetails();

	String updatePatientDetails(Integer id, String patientName, String patientEmail, String password,
			TypeOfPatient patientType, Integer age, String gender, Double double1);

	Patient getPatientById(Integer pid);

	String deletePatient(Integer pid);

	//Appointment bookAppointment(Integer integer, Integer integer2, String string, LocalDate appointmentDate);

	Patient authenticatePatient(String email, String password);

	boolean checkForPatient(String email);


}
