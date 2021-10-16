package com.ehospital.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehospital.pojos.Appointment;
import com.ehospital.pojos.Doctor;

public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {
	
	List<Appointment> getAppointmentBypatient_id(int patient_id);
	
	List<Appointment> getAppointmentByDoctorAndAppointmentDate(Doctor doctor,LocalDate date);

}
