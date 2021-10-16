package com.ehospital.pojos;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Report_Patients_Inventory")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Report extends BaseEntity {
	@ManyToOne
	@JoinColumn(name="reportId")
	private BasicReportDetails basicReportDetails;
	
	@ManyToOne
	@JoinColumn(name="patientId")
	private Patient patientId;
	
	@Lob
	@Column
	private byte[] reportDesc;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate reportIssueDate;


}
