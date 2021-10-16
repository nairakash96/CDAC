package com.ehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ehospital.pojos.HospitalEmployee;

public interface EmployeeRepository extends JpaRepository<HospitalEmployee, Integer>{

	//update employee details by id
	@Modifying
	@Query("update HospitalEmployee u set u.name = ?1, u.password = ?2, u.phoneNumber = ?3, u.address = ?4 where u.id = ?5")
	int setEmployeeDetailsById(String name, String password, String phoneNumber, String address, int id );

	HospitalEmployee findByEmailAndPassword(String email, String password);
	HospitalEmployee findByEmail(String email);

}
