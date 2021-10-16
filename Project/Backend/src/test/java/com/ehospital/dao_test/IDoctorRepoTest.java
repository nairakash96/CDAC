package com.ehospital.dao_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.repository.IPrescriptionRepository;

@SpringBootTest
class IDoctorRepoTest {

	
	@Autowired
	private IPrescriptionRepository doctorDao;
	
	@Test
	void testAddPrescription() {
		
	}
}
