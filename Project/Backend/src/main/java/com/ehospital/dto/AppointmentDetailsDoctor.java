package com.ehospital.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@AllArgsConstructor
public class AppointmentDetailsDoctor {
	
	private Integer patientID;
	private String patientName;
	private String patientEmail;
	private String deptName;
	private LocalDate date;
	private LocalTime time;
	
}
