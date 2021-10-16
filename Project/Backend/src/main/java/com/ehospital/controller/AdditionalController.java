package com.ehospital.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ehospital.dto.AppointmentDetailsDoctor;
import com.ehospital.dto.DoctorDTO;
import com.ehospital.pojos.Department;
import com.ehospital.pojos.Doctor;
import com.ehospital.repository.DepartmentRepository;
import com.ehospital.repository.DoctorRepository;
import com.ehospital.service.IAppointmentService;
import com.ehospital.service.IDepartmentService;
import com.ehospital.service.IEmployeeService;

@RestController
@CrossOrigin("*")
public class AdditionalController {

	@Autowired
	private DepartmentRepository deptRepo;
	
	@Autowired
	private DoctorRepository doctRepo;
	
	@Autowired
	private IAppointmentService appoRepo;
	
	@Autowired
	private IEmployeeService empService;

	@Autowired
	private IDepartmentService deptService;
	
	@GetMapping("/dep")
	public List<Department> getAllDepartments(){
		System.out.println("in get all departments");
		return deptService.getAllDepartments();
	}
	
	@GetMapping("/doctor/{deptId}")
	public ResponseEntity<?> getDoctorByDept(@PathVariable Integer deptId) {
		List<Doctor> doctorList = new ArrayList<>();
		List<DoctorDTO> list = new ArrayList<>();
		doctorList = doctRepo.findByDepartment(deptRepo.findById(deptId).get());
		doctorList.forEach((obj) -> {
			DoctorDTO temp = new DoctorDTO();
			temp.setId(obj.getDoctorId());
			temp.setName(empService.getEmployeeById(obj.getDoctorId()).getName());
			list.add(temp);
		});
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/doctor/appoitment/{docId}")
	public ResponseEntity<?> getAppointmentByDoctor(@PathVariable Integer docId) {
	
		List<AppointmentDetailsDoctor> list =  appoRepo.listDoctorAppointments(docId);
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}


}
