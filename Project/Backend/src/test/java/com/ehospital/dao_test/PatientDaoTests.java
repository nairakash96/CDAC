package com.ehospital.dao_test;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.pojos.Patient;
import com.ehospital.pojos.TypeOfPatient;
import com.ehospital.repository.PatientRepository;

@SpringBootTest
class PatientDaoTests {
	@Autowired
	private PatientRepository patientRepo;

	@Test
	void testAddPatient() {

		List<Patient> patients = Arrays.asList(
				new Patient("Sayali", "s@gmail.com", "Sayali", TypeOfPatient.OUT, "female", 25, 1050.0, null),
				new Patient("Tanmay", "tanmay@gmail.com", "Tanmay", TypeOfPatient.IN, "male", 15, 500.0, null),
				new Patient("Rama", "rama@gmail.com", "Rama", TypeOfPatient.OUT, "female", 54, 2500.0, null));
		patientRepo.saveAll(patients);

	}

}
