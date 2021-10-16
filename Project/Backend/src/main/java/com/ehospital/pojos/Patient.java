package com.ehospital.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Patient extends BaseEntity {
	
	private String patientName;
	@Column(unique = true)
	private String patientEmail;
	@Column(nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private TypeOfPatient patientType;
	private String gender;
	private Integer age;
	private Double totalBillAmount;
	
	@OneToMany(mappedBy = "patient",cascade = CascadeType.ALL,orphanRemoval = true,  fetch = FetchType.LAZY)
	@JsonIgnore
	List<Appointment> appointmentList = new ArrayList<>();
	
	

}
