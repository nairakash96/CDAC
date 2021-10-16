package com.ehospital.pojos;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Appointment extends BaseEntity{
	
	
	@ManyToOne
	@JoinColumn(name="doctor_id")
	private Doctor doctor;
	
	@ManyToOne
	@JoinColumn(name="patient_id")
	@JsonIgnoreProperties("appointmentList")
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;
	
	private LocalDate appointmentDate;
	
	
	private LocalTime appointmentTime;


}
