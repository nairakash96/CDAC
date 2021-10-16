package com.ehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ehospital.pojos.Doctor;

public interface IDoctorRepository extends JpaRepository<Doctor, Integer> {
	

}
