package com.ehospital.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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

public class Doctor{
	
	@Id
    private Integer doctorId;
	
	
	@ManyToOne
	@JoinColumn(name="department_id")
	
	private Department department;
	
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.LAZY)
	@JsonIgnore
	List<Appointment> appointmentList=new ArrayList<>();
	
	@JsonProperty
	@OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL,orphanRemoval = true)
	List<Prescription> prescriptionList=new ArrayList<>();
	
	

}
