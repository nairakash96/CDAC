package com.ehospital.service;

import java.util.List;

import com.ehospital.pojos.Patient;
import com.ehospital.pojos.Patient_Bed;

public interface IPatientBedService {

	String allocateBedToPatient(Patient_Bed newPatientBed);
	String deAllocateBedToPatient(Integer bedId);

	List<Patient_Bed> getAllAllocatedBedDetails();
	
	int getBedBillAmount(Patient patientId);
	
	Integer getBedIDByPatientID(Patient patient);
}
