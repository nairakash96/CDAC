package com.ehospital.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = "departmentName")})

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department extends BaseEntity{
	
	@NotEmpty
	private String departmentName;
	@OneToMany(mappedBy = "department",cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
	@JsonIgnore
	List<Doctor> doctorList=new ArrayList<>();

	
}
