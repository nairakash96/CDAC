package com.ehospital.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehospital.customexception.DepartmentHandlingException;
import com.ehospital.customexception.DoctorException;
import com.ehospital.customexception.EmployeeHandlingException;
import com.ehospital.customexception.PatientHandlingException;
import com.ehospital.dto.AppointmentDetailsDoctor;
import com.ehospital.dto.AppointmentDetailsPatient;
import com.ehospital.pojos.Appointment;
import com.ehospital.pojos.Doctor;
import com.ehospital.repository.AppointmentRepository;
import com.ehospital.repository.DepartmentRepository;
import com.ehospital.repository.DoctorRepository;
import com.ehospital.repository.EmployeeRepository;
import com.ehospital.repository.PatientRepository;

@Service
@Transactional
public class AppointmentServiceImpl implements IAppointmentService {


	@Autowired
	private PatientRepository patientRepo;

	@Autowired
	private AppointmentRepository appointmentRepo;

	@Autowired
	private DoctorRepository doctorRepo;

	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public Appointment bookAppointment(Integer patientId, Integer doctorId, Integer deptId, LocalDate appointmentDate, LocalTime appointmentTime) {

		Appointment app=new Appointment(doctorRepo.findById(doctorId).orElseThrow(()-> new DoctorException("Invalid Doctor ID")),
				patientRepo.findById(patientId).orElseThrow(()->new PatientHandlingException("Invalid Patient ID")),
				deptRepo.findById(deptId).orElseThrow(()->new DepartmentHandlingException("Invalid Department ID")), 
				appointmentDate, appointmentTime);
		return appointmentRepo.save(app);
	}

	@Override
	public List<AppointmentDetailsPatient> listAppointments(Integer pid) {
		List<Appointment> appointmentList = appointmentRepo.getAppointmentBypatient_id(pid);
		List<AppointmentDetailsPatient> list = new ArrayList<>();
				
		appointmentList.forEach((obj) -> {
			
			AppointmentDetailsPatient temp = new AppointmentDetailsPatient();
			temp.setDoctorName(empRepo.findById(obj.getDoctor().getDoctorId()).orElseThrow(()->new EmployeeHandlingException("Invalid Employee ID")).getName());
			temp.setDoctorEmail(empRepo.findById(obj.getDoctor().getDoctorId()).orElseThrow(()->new EmployeeHandlingException("Invalid Employee ID")).getEmail());
			temp.setDeptName(obj.getDepartment().getDepartmentName());
			temp.setDate(obj.getAppointmentDate());
			temp.setTime(obj.getAppointmentTime());
			list.add(temp);
			System.out.println(temp);
			System.out.println(list);
		});
		return list;
	}

	@Override
	public List<AppointmentDetailsDoctor> listDoctorAppointments(Integer did) {
		Doctor doctor=doctorRepo.findById(did).get();
		LocalDate date = LocalDate.now(); 
		List<Appointment> appointmentList = appointmentRepo.getAppointmentByDoctorAndAppointmentDate(doctor,date);
		List<AppointmentDetailsDoctor> list = new ArrayList<>();
				
		appointmentList.forEach((obj) -> {
			AppointmentDetailsDoctor temp = new AppointmentDetailsDoctor();
			temp.setPatientID(obj.getPatient().getId());
			temp.setPatientName(obj.getPatient().getPatientName());
			temp.setPatientEmail(obj.getPatient().getPatientEmail());
			temp.setDeptName(obj.getDepartment().getDepartmentName());
			temp.setDate(obj.getAppointmentDate());
			temp.setTime(obj.getAppointmentTime());
			list.add(temp);
			System.out.println(temp);
			System.out.println(list);
		});
		return list;
	}


}
