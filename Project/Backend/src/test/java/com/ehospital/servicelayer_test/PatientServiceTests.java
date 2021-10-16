package com.ehospital.servicelayer_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.pojos.Appointment;
import com.ehospital.pojos.Patient;
import com.ehospital.pojos.TypeOfPatient;
import com.ehospital.service.IAppointmentService;
import com.ehospital.service.IPatientService;

@SpringBootTest
class PatientServiceTests {
	@Autowired
	private IPatientService patientService;

	@Autowired
	private IAppointmentService appointmentService;

	@Test
	public void testCreatePatient() {
		Patient p1 = patientService.createPatient("Manali", "sayali@gmail.com", "Manali", TypeOfPatient.OUT, 18,
				"female", 0.0);
		Patient p2 = patientService.createPatient("Chaitali", "c@gmail.com", "Chaitali", TypeOfPatient.OUT, 23,
				"female", 0.0);
		assertEquals("Manali", p1.getPatientName());
	}

//	@Test
//	public void testGetAllPatientDetails() {
//		List<Patient> pList = patientService.getAllPatientDetails();
//		System.out.println(pList.size());
//		assertEquals(4, pList.size());
//	}
//
//	@Test
//	public void testUpdatePatient() {
//		String msg = patientService.updatePatientDetails(3, "Manali", "manasi@gmail.com", "Manasi", TypeOfPatient.IN,
//				23, "female", 1000.0);
//		assertEquals("update successfull...!!!", msg);
//	}
//
//	@Test
//	public void testDeletePatient() {
//		String msg = patientService.deletePatient(10);
//		assertEquals("Deleted Successfully", msg);
//	}
//
//	@Test
//	public void testBookAppointment() {
//		Appointment appo = appointmentService.bookAppointment(2, 1, "EYE01", LocalDate.parse("2021-03-29"));
//		assertEquals(1, appo.getSrNumber());
//	}

}
