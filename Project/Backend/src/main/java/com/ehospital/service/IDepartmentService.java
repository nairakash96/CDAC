package com.ehospital.service;

import java.util.List;

import com.ehospital.pojos.Department;


public interface IDepartmentService {
	//List of all departments
		List<Department> getAllDepartments();
	//Department by id
		Department getDepartmentById(int id);
	//adding department
		Department saveDepartmentDetails(Department e);
	//delete department
		String deleteDepartmentById(int id);
	//update employee details
		String updateDepartmentDetails(Department e,int id);
}
