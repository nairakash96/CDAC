package com.ehospital.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PrescriptationDetails {
	private int id;
	private String patientName;
	private String doctorName;
	private String deptName;
	private String precDec;
	private String diagnosis;
	private LocalDate precDate;

}
