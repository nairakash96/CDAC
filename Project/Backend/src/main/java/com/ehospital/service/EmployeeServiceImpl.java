package com.ehospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehospital.customexception.EmployeeHandlingException;
import com.ehospital.pojos.HospitalEmployee;
import com.ehospital.repository.EmployeeRepository;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<HospitalEmployee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public HospitalEmployee getEmployeeById(int id) {
		
		return employeeRepository.findById(id).orElseThrow(()->new EmployeeHandlingException("Invalid employee id"));
	}

	@Override
	public HospitalEmployee saveEmployeeDetails(HospitalEmployee e) {
	
		return employeeRepository.save(e);
	}

	@Override
	public String deleteEmployeeById(int id) {
		employeeRepository.deleteById(id);
		return "Employee deleted successfully";
	}

	@Override
	public String updateEmployeeDetails(HospitalEmployee e,int id) {
		
		int records=employeeRepository.setEmployeeDetailsById(e.getName(), e.getPassword(), e.getPhoneNumber(), e.getAddress(), id);
		if(records==1)
			return "employee details updated successfully";
		else
			return "employee details update failure";
	}

	@Override
	public HospitalEmployee authenticateUser(String email, String password) {
		return employeeRepository.findByEmailAndPassword(email, password);
	}

	@Override
	public boolean checkForEmployee(String email) {
		HospitalEmployee emp= employeeRepository.findByEmail(email);
		if(emp!=null)
			return true;
		else
			return false;
	}


}
