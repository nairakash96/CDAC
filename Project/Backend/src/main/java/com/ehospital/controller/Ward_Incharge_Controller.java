package com.ehospital.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ehospital.filehandling.ResponseMessage;
import com.ehospital.pojos.Bed;
import com.ehospital.pojos.Patient_Bed;
import com.ehospital.pojos.TypeOfPatient;
import com.ehospital.service.IBedService;
import com.ehospital.service.IPatientBedService;
import com.ehospital.service.IPatientService;

@RestController
@CrossOrigin("*")
@RequestMapping("/bed")
public class Ward_Incharge_Controller {

	@Autowired
	private IBedService bedService;
	
	@Autowired
	private IPatientBedService patientBedService;
	
	@Autowired
	private IPatientService patientService;
	
	public Ward_Incharge_Controller()
	{
		System.out.println("In constr of "+getClass().getName());
	}
	
	@GetMapping("/checkAvailableBeds")
	public List<Bed> getAvailableBeds()
	{
		System.out.println("In controller - getAvailableBeds ");
		return bedService.getAllAvailableBeds();
	}

	@PostMapping
	public ResponseEntity<?> createBasicBed(@RequestBody Bed newBed)
	{
		System.out.println("In controller - createBasicBed");
		return new ResponseEntity<>(bedService.addNewBed(newBed), HttpStatus.CREATED);
	}
	
	@GetMapping("/{bid}")
	public Bed getBedById(@PathVariable Integer bid)
	{
		System.out.println("In controller - getBedById");
		return bedService.getBed(bid);
	}
//	
//	@PutMapping("/{bid}/{bstatus}")
//	public ResponseEntity<String> updateBedDetails(@PathVariable Integer bid,@PathVariable int bstatus)
//	{
//		System.out.println("In controller - updateBedDetails");
//		return ResponseEntity.ok(bedService.updateBedStatus(bid, bstatus));
//	}
		
//	@DeleteMapping("/{bid}")
//	public ResponseEntity<String> deleteBed(@PathVariable Integer bid)
//	{
//		System.out.println("In controller - deleteBed");
//		return ResponseEntity.ok(bedService.deleteBedById(bid));
//	}
	
	@PostMapping("/allocatePatientBed")
	public ResponseEntity<ResponseMessage> allocateBedToPatient(@RequestParam Integer bid,@RequestParam Integer pid,@RequestParam String fromDate,@RequestParam String toDate)
	{
		String message="";
		System.out.println("In controller - allocateBedToPatient");
		if(LocalDate.parse(fromDate).isAfter(LocalDate.parse(toDate)))
		{
			message="Allocation date cannot be after Deallocation date";
			
		}
		else if(LocalDate.parse(fromDate).isBefore(LocalDate.now()))
		{
			message="Allocation Date cannot be before Current Date";
		}
		else if(patientService.getPatientById(pid).getPatientType().equals(TypeOfPatient.OUT))
		{
			message="Patient Type is OUT - Cannot be allocated Bed";

		}
			
			else 
		{
			Patient_Bed patientBed=new Patient_Bed(bid, patientService.getPatientById(pid), LocalDate.parse(fromDate), LocalDate.parse(toDate));
			patientBedService.allocateBedToPatient(patientBed);
			message="Bed ID :"+bid+" Allocated to Patient ID: "+pid;
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));

	}
	
	@GetMapping
	public List<Bed> getAllBeds()
	{
		System.out.println("In controller - getAllBeds ");
		return bedService.getAllBeds();
	}
	
	@GetMapping("/checkAllocatedBeds")
	public List<Patient_Bed> getAllocateBeds()
	{
		System.out.println("In controller - getAllocateBeds");
		return bedService.getAllAllocatedBeds();
	}
	
	@DeleteMapping("/deallocatePatientBed")
	public ResponseEntity<String> deallocatePatientBed(@RequestParam Integer bedId)
	{
		System.out.println("In controller - deallocatePatientBed");
		return ResponseEntity.ok(patientBedService.deAllocateBedToPatient(bedId));
	}
	
	@GetMapping("/bedBillAmount")
	public ResponseEntity<?> calculateBedBill(@RequestParam Integer pid)
	{
		System.out.println("In controller - calculateBedBill");
		return ResponseEntity.ok(patientBedService.getBedBillAmount(patientService.getPatientById(pid)));
	}
}
