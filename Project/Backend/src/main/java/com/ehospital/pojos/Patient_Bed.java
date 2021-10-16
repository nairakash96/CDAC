package com.ehospital.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(uniqueConstraints = {
		   @UniqueConstraint(columnNames = {"allocatedBedID"}),
		   @UniqueConstraint( columnNames = {"allocatedToPatientID"})})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Patient_Bed extends BaseEntity{

	
	@Column
	private Integer allocatedBedID;
	
	@OneToOne
	@JoinColumn(name = "allocatedToPatientID")
	private Patient allocatedToPatientID;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fromDate;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate toDate;
}
