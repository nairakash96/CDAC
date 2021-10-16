package com.ehospital.dao_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.customexception.BedHandlingException;
import com.ehospital.pojos.Bed;
import com.ehospital.pojos.Patient;
import com.ehospital.pojos.Patient_Bed;
import com.ehospital.pojos.TypeOfPatient;
import com.ehospital.repository.BedRepository;
import com.ehospital.repository.PatientRepository;
import com.ehospital.repository.Patient_Bed_Repository;

@SpringBootTest
class IPatientBed_RepoTest {

	
	@Autowired
	private Patient_Bed_Repository patientBedRepo;
	
	@Autowired
	private BedRepository bedRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Test
	void testAllocateBedToPatient() {

		Patient_Bed patientBed1=new Patient_Bed(3, patientRepo.findById(2).orElseThrow(()->new BedHandlingException("Invalid Patient ID")), LocalDate.parse("2021-03-12"), LocalDate.parse("2021-03-15"));
		patientBedRepo.save(patientBed1);
		bedRepo.updateBedStatus(patientBed1.getAllocatedBedID(), 1);
		}
	


}
