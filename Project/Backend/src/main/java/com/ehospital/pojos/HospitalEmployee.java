package com.ehospital.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
public class HospitalEmployee extends BaseEntity {

	private String name;
	@Column(unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role;
	private String phoneNumber;
	private String address;
	
	

}
