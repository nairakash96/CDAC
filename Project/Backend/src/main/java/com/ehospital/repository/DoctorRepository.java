package com.ehospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ehospital.pojos.Department;
import com.ehospital.pojos.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
	
	
	List<Doctor> findByDepartment(Department d);
	
	@Modifying
	@Query("update Doctor set department=:dept where doctorId=:did")
	void setDoctorDepartment(@Param("dept") Department department,@Param("did") Integer doctorId);

}
