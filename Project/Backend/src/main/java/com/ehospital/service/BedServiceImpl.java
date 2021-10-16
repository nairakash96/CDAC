package com.ehospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehospital.customexception.BedHandlingException;
import com.ehospital.pojos.Bed;
import com.ehospital.pojos.Patient_Bed;
import com.ehospital.repository.BedRepository;
import com.ehospital.repository.Patient_Bed_Repository;

@Service
@Transactional
public class BedServiceImpl implements IBedService {

	@Autowired
	private BedRepository bedRepo;
	
	@Autowired
	private Patient_Bed_Repository patientBedRepo;
	
	@Override
	public Bed addNewBed(Bed newBed) {
		// TODO Auto-generated method stub
		return bedRepo.save(newBed);
	}

	@Override
	public String deleteBedById(Integer bedId) {
		// TODO Auto-generated method stub
		bedRepo.deleteById(bedId);
		return "Deleted Bed Successfully";
	}

	@Override
	public String updateBedStatus(Integer bedId, int bedStatus) {
		// TODO Auto-generated method stub
		bedRepo.findById(bedId).orElseThrow(()->new BedHandlingException("Invalid BedID"));
		bedRepo.updateBedStatus(bedId, bedStatus);
		return "Updated Bed Status successfully!!";
	}

	@Override
	public List<Bed> getAllBeds() {
		// TODO Auto-generated method stub
		return bedRepo.findAll();
	}

	@Override
	public List<Bed> getAllAvailableBeds() {
		// TODO Auto-generated method stub
		return bedRepo.listAvailableBeds();
	}

	@Override
	public Bed getBed(Integer bedId) {
		// TODO Auto-generated method stub
		return bedRepo.findById(bedId).orElseThrow(()->new BedHandlingException("Invalid Bed ID"));
	}

	@Override
	public List<Patient_Bed> getAllAllocatedBeds() {
		// TODO Auto-generated method stub
		return patientBedRepo.findAll();
	}

}
