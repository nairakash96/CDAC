package com.ehospital.service;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehospital.customexception.DepartmentHandlingException;
import com.ehospital.customexception.DoctorException;
import com.ehospital.customexception.PatientHandlingException;
import com.ehospital.pojos.Appointment;
import com.ehospital.pojos.Patient;
import com.ehospital.pojos.TypeOfPatient;
import com.ehospital.repository.AppointmentRepository;
import com.ehospital.repository.DepartmentRepository;
import com.ehospital.repository.DoctorRepository;
import com.ehospital.repository.PatientRepository;

@Service
@Transactional
public class PatientServiceImpl implements IPatientService {

	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private AppointmentRepository appointmentRepo;

	@Autowired
	private DoctorRepository doctorRepo;

	@Autowired
	private DepartmentRepository deptRepo;

	@Override
	public Patient createPatient(String patientName, String patientEmail, String password, TypeOfPatient patientType,
			Integer age, String gender, double bill) {
		return patientRepo.save(new Patient(patientName, patientEmail, password, patientType, gender, age, 0.0, null));

	}

	@Override
	public List<Patient> getAllPatientDetails() {
		return patientRepo.findAll();
	}

	@Override
	public String updatePatientDetails(Integer id, String patientName, String patientEmail, String password,
			TypeOfPatient patientType, Integer age, String gender, Double totalBillAmount) {
		patientRepo.findById(id)
				.orElseThrow(() -> new PatientHandlingException("Patient with id:" + id + " does not exist!!"));
		int result = patientRepo.updatePatientById(id, patientName, patientEmail, password, patientType, age, gender,
				totalBillAmount);
		if (result == 1)
			return "update successfull...!!!";
		return "update failed";
	}

	@Override
	public Patient getPatientById(Integer pid) {
		return patientRepo.findById(pid).get();
	}

	@Override
	public String deletePatient(Integer pid) {
		patientRepo.deleteById(pid);
		return "Deleted Successfully";
	}
//
//	@Override
//	public Appointment bookAppointment(Integer patientId, Integer doctorId, String deptId, LocalDate appointmentDate, LocalTime appointmentTime) {
//
//		return appointmentRepo.save(new Appointment(null, doctorRepo.findById(doctorId).get(),
//				patientRepo.findById(patientId).get(), deptRepo.findById(deptId).get(), appointmentDate, appointmentTime));
//	}

	@Override
	public Patient authenticatePatient(String email, String password) {

		Patient patient = patientRepo.findByPatientEmailAndPassword(email, password);
		System.out.println("Patient: " + patient);
		return patient;
	}

	@Override
	public boolean checkForPatient(String email) {
		Patient patient = patientRepo.findByPatientEmail(email);
		if (patient != null)
			return true;
		else
			return false;
	}

}
