package com.ehospital.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AppointmentDTO {
	
	private LocalDate appointmentDate;
	private LocalTime appointmentTime;
	private Integer deptId;
	private Integer patientId;
	private Integer doctorId;

}
