package com.ehospital.servicelayer_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.pojos.Bed;
import com.ehospital.pojos.Patient_Bed;
import com.ehospital.service.IBedService;
import com.ehospital.service.IPatientBedService;
import com.ehospital.service.IPatientService;

@SpringBootTest
class BedServiceTest {

	
	@Autowired 
	private IBedService bedService;
	
	@Autowired
	private IPatientBedService patientBedService;
	
	@Autowired
	private IPatientService patientService;
	
//	@Test
//	void addBasicBed()
//	{
//		for(int i=0;i<6;i++)
//		{
//			bedService.addNewBed(new Bed(0));
//
//		}
//		
//		assertEquals(bedService.getAllBeds().size(), 6);
//	}
	
//	@Test
//	void testAvailableBeds()
//	{
//		assertEquals(bedService.getAllAvailableBeds().size(), 2);
//	}
	
//	@Test
//	void testAllocatedBeds()
//	{
//		assertEquals(patientBedService.getAllAllocatedBedDetails().size(), 1);
//	}
//	
	@Test
	void testAllocateBedToPatient()
	{
		Patient_Bed patientBed1=new Patient_Bed(
				bedService.getBed(1).getId(),
				patientService.getPatientById(1),
				LocalDate.parse("2021-09-24"),
				LocalDate.parse("2021-09-29"));
		patientBedService.allocateBedToPatient(patientBed1);
		assertEquals(patientBedService.getAllAllocatedBedDetails().size(), 1);
	}

}
