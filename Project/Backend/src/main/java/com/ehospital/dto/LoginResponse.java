package com.ehospital.dto;

import org.springframework.stereotype.Component;

import com.ehospital.pojos.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class LoginResponse {	
	String message;
	Role role;
}
