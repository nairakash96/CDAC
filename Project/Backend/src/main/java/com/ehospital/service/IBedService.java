package com.ehospital.service;

import java.util.List;

import com.ehospital.pojos.Bed;
import com.ehospital.pojos.Patient_Bed;

public interface IBedService {

	Bed addNewBed(Bed newBed);
	String deleteBedById(Integer bedId);
	String updateBedStatus(Integer bedId,int bedStatus);
	List<Bed> getAllBeds();
	List<Bed> getAllAvailableBeds();
	List<Patient_Bed> getAllAllocatedBeds();

	Bed getBed(Integer bedId);
	
}
