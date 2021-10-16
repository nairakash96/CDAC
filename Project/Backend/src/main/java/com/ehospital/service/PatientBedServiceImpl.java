package com.ehospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehospital.customexception.BedHandlingException;
import com.ehospital.customexception.PatientHandlingException;
import com.ehospital.pojos.Patient;
import com.ehospital.pojos.Patient_Bed;
import com.ehospital.repository.BedRepository;
import com.ehospital.repository.PatientRepository;
import com.ehospital.repository.Patient_Bed_Repository;

@Service
@Transactional
public class PatientBedServiceImpl implements IPatientBedService {

	@Autowired
	private Patient_Bed_Repository patientBedRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired
	private BedRepository bedRepo;

	@Override
	public String allocateBedToPatient(Patient_Bed newPatientBed) {
		// TODO Auto-generated method stub
		bedRepo.findById(newPatientBed.getAllocatedBedID()).orElseThrow(()->new BedHandlingException("Invalid BedID"));
		patientRepo.findById(newPatientBed.getAllocatedToPatientID().getId()).orElseThrow(()->new PatientHandlingException("Invalid Patient ID"));
		
		patientBedRepo.save(newPatientBed);
		bedRepo.updateBedStatus(newPatientBed.getAllocatedBedID(), 1);
		return "Bed ID: "+newPatientBed.getAllocatedBedID()+" allotted to Patient ID : "+newPatientBed.getAllocatedToPatientID().getId();
	}

	@Override
	public List<Patient_Bed> getAllAllocatedBedDetails() {
		// TODO Auto-generated method stub
		return patientBedRepo.findAll();
	}

	@Override
	public String deAllocateBedToPatient(Integer bedId) {
		// TODO Auto-generated method stub
		bedRepo.findById(bedId).orElseThrow(()->new BedHandlingException("Invalid BedID"));
		patientBedRepo.deleteByAllocatedBedID(bedId);
		bedRepo.updateBedStatus(bedId, 0);
		return "Deallocated Bed Successfully";
	}

	@Override
	public int getBedBillAmount(Patient patientId) {
		// TODO Auto-generated method stub
		return patientBedRepo.numberOfDaysAdmitted(patientId)*500;
	}

	@Override
	public Integer getBedIDByPatientID(Patient patient) {
		// TODO Auto-generated method stub
		return patientBedRepo.findByAllocatedBedID(patient);
	}
	
	
}
