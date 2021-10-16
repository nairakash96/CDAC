package com.ehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ehospital.pojos.Patient;
import com.ehospital.pojos.Patient_Bed;

@Repository
public interface Patient_Bed_Repository extends JpaRepository<Patient_Bed, Integer>{

	@Modifying
	@Query("delete  from Patient_Bed p where p.allocatedBedID=:bid")
	void deleteByAllocatedBedID(@Param("bid")Integer bedId);
	
	@Query("select datediff(toDate,fromDate) from Patient_Bed where allocatedToPatientID=:pid")
	int numberOfDaysAdmitted(@Param("pid") Patient patientId);
	
	@Query("select allocatedBedID from Patient_Bed where allocatedToPatientID=:pid")
	Integer findByAllocatedBedID(@Param("pid") Patient patientId);
}
