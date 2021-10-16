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
import org.springframework.web.bind.annotation.RestController;

import com.ehospital.pojos.Department;
import com.ehospital.service.IDepartmentService;

@RestController // To tell SC , following class serves as the REST API endpoint (=@Controller
// class level + @ResponseBody added over ret types of all req handling methods
@RequestMapping("/department")
@CrossOrigin(origins = "*")
public class DepartmentController {

	@Autowired
	private IDepartmentService deptService;

	public DepartmentController() {
		System.out.println("in ctor of " + getClass().getName());
	}
	
	@GetMapping
	public List<Department> getAllDepartments(){
		System.out.println("in get all departments");
		return deptService.getAllDepartments();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getDepartmentById(@PathVariable int id){
		System.out.println("int get department by id");
		return ResponseEntity.ok(deptService.getDepartmentById(id));
	}
	
	@PostMapping
	public ResponseEntity<?> saveDepartment(@RequestBody Department d) {
		System.out.println("in save department " + d);
		if(d.getDepartmentName().equals(null)) {
			throw new NullPointerException();
		}
		return new ResponseEntity<>(deptService.saveDepartmentDetails(d), HttpStatus.CREATED);
	
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserDetails(@PathVariable int id) {
		System.out.println("in delete department details " + id);
		return ResponseEntity.ok(deptService.deleteDepartmentById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserDetails(@RequestBody Department d, @PathVariable int id) {
		System.out.println("in update " + d + " " + id);
		// chk if user exists by id
		deptService.getDepartmentById(id);
		return ResponseEntity.ok(deptService.updateDepartmentDetails(d, id));
	}
	
}
