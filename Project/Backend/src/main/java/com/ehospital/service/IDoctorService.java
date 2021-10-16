package com.ehospital.service;

import java.time.LocalDate;
import java.util.List;

import com.ehospital.dto.PrescriptationDetails;
import com.ehospital.dto.PrescriptationDetailsDoctor;
import com.ehospital.dto.PrescriptionDetailsPatient;
import com.ehospital.pojos.Appointment;
import com.ehospital.pojos.Department;
import com.ehospital.pojos.Prescription;

public interface IDoctorService {
	Prescription createPrescription(Integer did, Integer pid, String a, String diag,LocalDate precDate);

	List<Prescription> getPrescriptionBypcpidAndpid(Integer prescptionId, Integer patientId);

	List<Prescription> getPrescriptionBypidAnddocId(Integer patientId, Integer doctorId);

	Prescription getPrecsptionById(Integer precpId);

	List<PrescriptationDetailsDoctor> listPrescriptationDid(Integer did);

	List<PrescriptionDetailsPatient> listPrescriptionPid(Integer pid);

	List<PrescriptationDetails> listAllPrescriptation();

	List<Appointment> getAllAppointments();

	String assignDepartmentToDoctor(Department dept, Integer docId);

}
