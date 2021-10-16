package com.ehospital.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ehospital.pojos.Doctor;
import com.ehospital.pojos.HospitalEmployee;
import com.ehospital.pojos.Role;
import com.ehospital.repository.DoctorRepository;
import com.ehospital.service.IDepartmentService;
import com.ehospital.service.IDoctorService;
import com.ehospital.service.IEmployeeService;

@RestController // To tell SC , following class serves as the REST API endpoint (=@Controller
				// class level + @ResponseBody added over ret types of all req handling methods
@RequestMapping("/employee")
@CrossOrigin(origins = "*")
public class AdminController {
	// dependency : service layer i/f
	@Autowired
	private IEmployeeService employeeService;
	
	@Autowired
	private IDoctorService doctorService;
	
	@Autowired
	private IDepartmentService deptService;
	
	@Autowired
	private DoctorRepository docRepo;

	public AdminController() {
		System.out.println("in ctor of " + getClass().getName());

	}
	
	
	@GetMapping
	public List<HospitalEmployee> getAllEmployees(){
		System.out.println("in get all employees");
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable int id){
		System.out.println("int get employee by id");
		return ResponseEntity.ok(employeeService.getEmployeeById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> saveEmployee(@RequestBody HospitalEmployee emp) {
		System.out.println("in save employee " + emp);
		HospitalEmployee savedEmployee=employeeService.saveEmployeeDetails(emp);
		if(emp.getRole().equals(Role.DOCTOR))
		{
			Doctor d1=new Doctor();
			d1.setDoctorId(savedEmployee.getId());
			docRepo.save(d1);
		}
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	
	}

	@PutMapping("/assignDoctorToDepartment")
	public ResponseEntity<?> assignDepartmentToDoctor(@RequestParam Integer did,@RequestParam Integer deptid) {
		// chk if user exists by id
		System.out.println("In assign department to doctor");
		System.out.println(did);
		System.out.println(deptid);
		return ResponseEntity.ok(doctorService.assignDepartmentToDoctor(deptService.getDepartmentById(deptid), did));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserDetails(@PathVariable int id) {
		System.out.println("in del emp details " + id);
		docRepo.deleteById(id);
		return ResponseEntity.ok(employeeService.deleteEmployeeById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserDetails(@RequestBody HospitalEmployee emp, @PathVariable int id) {
		System.out.println("in update " + emp + " " + id);
		// chk if user exists by id
		employeeService.getEmployeeById(id);
		return ResponseEntity.ok(employeeService.updateEmployeeDetails(emp,id));
	}

	 

}
