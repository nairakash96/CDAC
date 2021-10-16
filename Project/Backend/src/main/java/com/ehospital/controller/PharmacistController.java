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

import com.ehospital.pojos.Medicine;
import com.ehospital.service.IMedicineService;

@RestController
@CrossOrigin("*")
@RequestMapping("/medicine")
public class PharmacistController {

	@Autowired
	private IMedicineService medicineService;
	
	public PharmacistController()
	{
		System.out.println("In constr of "+getClass().getName());
	}
	
	@GetMapping
	public List<Medicine> getMedicines()
	{
		System.out.println("In controller - getMedicinesList ");
		return medicineService.getAllMedicines();
	}
	
	@GetMapping("/{mid}")
	public Medicine getMedicineById(@PathVariable Integer mid)
	{
		System.out.println("In controller - getMedicineById");
		return medicineService.getMedicineById(mid);
	}
		
	@PostMapping
	public ResponseEntity<?> createMedicine(@RequestBody Medicine newMedicine)
	{
		System.out.println("In controller - createMedicine");
		return new ResponseEntity<>(medicineService.addMedicine(newMedicine), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateMedicineDetails")
	public ResponseEntity<String> updateMedicineDetails(@RequestParam int quantity,@RequestParam Integer medicineId)
	{
		System.out.println("In controller - updateMedicineDetails");
		return ResponseEntity.ok(medicineService.updateMedicineDetails(quantity, medicineId));
	}


	
	@DeleteMapping("/{mid}")
	public ResponseEntity<String> deleteMedicine(@PathVariable Integer mid)
	{
		System.out.println("In controller - deleteMedicine");
		return ResponseEntity.ok(medicineService.deleteMedicineById(mid));
	}
	
	
	
}
