package com.ehospital.service;

import java.util.List;

import com.ehospital.pojos.HospitalEmployee;

public interface IEmployeeService {
//List of all employees
	List<HospitalEmployee> getAllEmployees();
//Employee by id
	HospitalEmployee getEmployeeById(int id);
//adding employee details
	HospitalEmployee saveEmployeeDetails(HospitalEmployee e);
//delete employee by id
	String deleteEmployeeById(int id);
//update employee details
	String updateEmployeeDetails(HospitalEmployee e,int id);
	
	HospitalEmployee authenticateUser(String email, String password);
	boolean checkForEmployee(String email);

}
