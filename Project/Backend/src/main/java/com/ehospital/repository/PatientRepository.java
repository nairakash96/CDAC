package com.ehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ehospital.pojos.Patient;
import com.ehospital.pojos.TypeOfPatient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

//	List<Patient> findAll();
//
//	Optional<Patient> findById(Integer id);
//
//	Patient save(Patient patient);
//
//	void deleteById(Integer id);

	@Modifying
	@Query("update Patient p set p.patientName =:patientName, p.patientEmail =:patientEmail, p.password=:password,"
			+ "p.patientType=:patientType, p.age=:age, p.gender=:gender, p.totalBillAmount=:totalBillAmount where p.id =:id")
	int updatePatientById( Integer id, String patientName, String patientEmail, String password,
			TypeOfPatient patientType, Integer age, String gender, Double totalBillAmount);

	Patient findByPatientEmail(String email);
 
	Patient findByPatientEmailAndPassword(String email, String password);
}
