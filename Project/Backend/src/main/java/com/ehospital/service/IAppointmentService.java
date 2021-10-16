package com.ehospital.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.ehospital.dto.AppointmentDetailsDoctor;
import com.ehospital.dto.AppointmentDetailsPatient;
import com.ehospital.pojos.Appointment;

public interface IAppointmentService {

	Appointment bookAppointment(Integer patientId, Integer doctorId, Integer deptId, LocalDate appointmentDate, LocalTime appointmentTime  );

	List<AppointmentDetailsPatient> listAppointments(Integer pid);

	List<AppointmentDetailsDoctor> listDoctorAppointments(Integer did);

}
