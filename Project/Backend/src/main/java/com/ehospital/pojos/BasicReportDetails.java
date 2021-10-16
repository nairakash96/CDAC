package com.ehospital.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Basic_Report_Details",uniqueConstraints = {@UniqueConstraint(columnNames = "reportName")})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class BasicReportDetails extends BaseEntity{

	@Column
	private String reportName;

}
