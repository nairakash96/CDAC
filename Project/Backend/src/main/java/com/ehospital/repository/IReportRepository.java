package com.ehospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import com.ehospital.pojos.Patient;
import com.ehospital.pojos.Report;

@Repository
public interface IReportRepository extends JpaRepository<Report, Integer>{

	@Query(value="select * from report_patients_inventory  where patient_id=:pid",nativeQuery = true)
	List<Report> findByPatientId(@Param("pid") Patient patientId);

	@Query(value =  "select * from report_patients_inventory  where report_id=:rid",nativeQuery=true)
	List<Report> findByReportId(@Param("rid") Integer reportId);
	
	@Query(value =  "select * from report_patients_inventory  where report_id=:rid and patient_id=:pid",nativeQuery=true)
	List<Report> findByReportIdAndPatientId(@Param("pid") Patient patientId,@Param("rid") Integer reportId);
	
	@Query(value="update report_patients_inventory set report_desc=:rdesc where patient_id=:pid and report_id=:rid",nativeQuery = true)
	void updatePatientReport(@Param("pid") Patient patientid,@Param("rdesc") MultipartFile file,@Param("rid") Integer reportId);
}
