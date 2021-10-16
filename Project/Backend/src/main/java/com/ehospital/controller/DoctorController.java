
package com.ehospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehospital.dto.PrescriptationDetails;
import com.ehospital.dto.PrescriptionDetailsPatient;
import com.ehospital.pojos.Prescription;
import com.ehospital.service.IDoctorService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/prescription")
public class DoctorController {

	@Autowired
	private IDoctorService doctorService;
//		@Autowired
//		private IMedicineService medicineService;

	public DoctorController() {
		System.out.println("In constr of " + getClass().getName());
	}

	@GetMapping
	public List<PrescriptationDetails> getPrescription() {
		System.out.println("In controller - getAllPrescription ");
		return doctorService.listAllPrescriptation();
	}

	@GetMapping("/{pcpid}" + "/{patientId}")
	public List<Prescription> getPrescriptionBypcpid(@PathVariable Integer pcpid, @PathVariable Integer patientId) {
		System.out.println("In Controller -getPrescriptionBypcpidAndpid");
		return doctorService.getPrescriptionBypcpidAndpid(pcpid, patientId);
	}

	@GetMapping("/{patientId}-")
	public List<PrescriptionDetailsPatient> getPrescriptionByPId(@PathVariable Integer patientId) {

		System.out.println("In controller - getPrescriptionByPatientId");
		return doctorService.listPrescriptionPid(patientId);
	}

	@GetMapping("/{precpId}")
	public Prescription getPrecsptionById(@PathVariable Integer precpId) {

		System.out.println("In controller - getPrescriptionByPrecptionId");
		return doctorService.getPrecsptionById(precpId);
	}

	@GetMapping("/{patId}" + "/{docId}-")
	List<Prescription> getPrescriptionBypidAnddocId(@PathVariable Integer patId, @PathVariable Integer docId) {
		System.out.println("In Controller -getPrescriptionBypidAnddocId");
		return doctorService.getPrescriptionBypidAnddocId(patId, docId);
	}

	@PostMapping
	public ResponseEntity<?> createPrescription(@RequestBody Prescription pres) {
		System.out.println("In controller - createPrescription");
		Prescription createdPrescription= doctorService.createPrescription(pres.getDoctor().getDoctorId(), pres.getPatient().getId(), pres.getPrescription(),pres.getDiagnosis(), pres.getPrescriptionDate());
		System.out.println(createdPrescription.getDoctor().getDoctorId());	
		return new ResponseEntity<>(createdPrescription, HttpStatus.CREATED);
 
		
	}

}
