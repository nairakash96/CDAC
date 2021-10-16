package com.ehospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehospital.customexception.DepartmentHandlingException;
import com.ehospital.pojos.Department;
import com.ehospital.repository.DepartmentRepository;

@Service
@Transactional
public class DepartmentServiceImpl implements IDepartmentService{

	@Autowired
	private DepartmentRepository deptRepo;
	
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return deptRepo.findAll();
	}

	@Override
	public Department getDepartmentById(int id) {
		// TODO Auto-generated method stub
		return deptRepo.findById(id).orElseThrow(()->new DepartmentHandlingException("Invalid department id"));
	}

	@Override
	public Department saveDepartmentDetails(Department e) {
		// TODO Auto-generated method stub
		return deptRepo.save(e);
	}

	@Override
	public String deleteDepartmentById(int id) {
		// TODO Auto-generated method stub
		deptRepo.deleteById(id);
		return "Department deleted successfully";
	}

	@Override
	public String updateDepartmentDetails(Department e, int id) {
		int records=deptRepo.setDepartmentDetailsById(e.getDepartmentName(), id);
		if(records==1)
			return "department details updated successfully";
		else
			return "department details update failure";
	}

}
