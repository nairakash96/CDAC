package com.ehospital.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehospital.customexception.DepartmentHandlingException;
import com.ehospital.customexception.DoctorException;
import com.ehospital.customexception.EmployeeHandlingException;
import com.ehospital.customexception.PatientHandlingException;
import com.ehospital.customexception.PresciptationHandlingExceptation;
import com.ehospital.dto.PrescriptationDetails;
import com.ehospital.dto.PrescriptationDetailsDoctor;
import com.ehospital.dto.PrescriptionDetailsPatient;
import com.ehospital.pojos.Appointment;
import com.ehospital.pojos.Department;
import com.ehospital.pojos.Doctor;
import com.ehospital.pojos.Patient;
import com.ehospital.pojos.Prescription;
import com.ehospital.repository.AppointmentRepository;
import com.ehospital.repository.DepartmentRepository;
import com.ehospital.repository.DoctorRepository;
import com.ehospital.repository.EmployeeRepository;
import com.ehospital.repository.IDoctorRepository;
import com.ehospital.repository.IPrescriptionRepository;
import com.ehospital.repository.PatientRepository;

@Service
@Transactional
public class DoctorServiceImpl implements IDoctorService {
	@Autowired
	private IPrescriptionRepository PrecRepo;
	@Autowired
	private IDoctorRepository DocRepo;
	@Autowired
	private PatientRepository patRepo;
	@Autowired
	private AppointmentRepository appRepo;
	@Autowired
	private EmployeeRepository empRepo;
	@Autowired
	private DepartmentRepository depRepo;
	@Autowired
	private DoctorRepository doctorRepo;

	@Override
	public Prescription createPrescription(Integer did, Integer pid, String a,String diag, LocalDate precDate) {
		// TODO Auto-generated method stub
		Patient pat = patRepo.findById(pid).orElseThrow(() -> new PatientHandlingException("Invalid Patient Id"));
		Doctor doct = DocRepo.findById(did).orElseThrow(() -> new DoctorException("Invalid Doctor Id"));
		Prescription p = new Prescription(doct, pat, a,diag, precDate);
		return PrecRepo.save(p);
	}

	@Override
	public List<PrescriptionDetailsPatient> listPrescriptionPid(Integer pid) {
		List<Prescription> prescriptationList = PrecRepo.findByPatientId(pid);
		List<PrescriptionDetailsPatient> list = new ArrayList<>();

		prescriptationList.forEach((obj) -> {
			PrescriptionDetailsPatient temp = new PrescriptionDetailsPatient();
			temp.setId(PrecRepo.findById(obj.getId())
					.orElseThrow(() -> new PresciptationHandlingExceptation("Invalid Prescriptation Id")).getId());
			temp.setDoctorName(empRepo.findById(obj.getDoctor().getDoctorId())
					.orElseThrow(() -> new EmployeeHandlingException("Invalid Employee ID")).getName());
//			temp.setPatientName(patRepo.findById(obj.getPatient().getPatientId())
//					.orElseThrow(() -> new PatientException("Invalid Patient ID")).getPatientName());
			temp.setDiagnosis(obj.getDiagnosis().toString());
			temp.setPrecDate(obj.getPrescriptionDate());
			temp.setPrecDec(obj.getPrescription().toString());
			list.add(temp);
			System.out.println(temp);
			System.out.println(list);
		});
		return list;
	}

	public List<PrescriptationDetailsDoctor> listPrescriptationDid(Integer did) {
		List<Prescription> prescriptationList = PrecRepo.findByDoctorId(did);
		List<PrescriptationDetailsDoctor> list = new ArrayList<>();

		prescriptationList.forEach((obj) -> {
			PrescriptationDetailsDoctor temp = new PrescriptationDetailsDoctor();
			temp.setId(PrecRepo.findById(obj.getId())
					.orElseThrow(() -> new PresciptationHandlingExceptation("Invalid Prescriptation Id")).getId());
			temp.setPatientName(patRepo.findById(obj.getPatient().getId())
					.orElseThrow(() -> new PatientHandlingException("Invalid Patient ID")).getPatientName());
			temp.setDiagnosis(obj.getDiagnosis().toString());
			temp.setPrecDec(obj.getPrescription().toString());
			temp.setPrecDate(obj.getPrescriptionDate());
			list.add(temp);
			System.out.println("temp");
			System.out.println("list");
		});
		return list;
	}

	@Override
	public List<PrescriptationDetails> listAllPrescriptation() {
		List<Prescription> prescriptationList = PrecRepo.findAll();
		List<PrescriptationDetails> list = new ArrayList<>();

		prescriptationList.forEach((obj) -> {
			PrescriptationDetails temp = new PrescriptationDetails();
			temp.setId(PrecRepo.findById(obj.getId())
					.orElseThrow(() -> new PresciptationHandlingExceptation("Invalid Prescriptation Id")).getId());
			temp.setDoctorName(empRepo.findById(obj.getDoctor().getDoctorId())
					.orElseThrow(() -> new EmployeeHandlingException("Invalid Employee ID")).getName());
			temp.setDeptName(depRepo.findById(obj.getDoctor().getDepartment().getId())
					.orElseThrow(() -> new DepartmentHandlingException("Invalid Department Id")).getDepartmentName());
			temp.setPatientName(patRepo.findById(obj.getPatient().getId())
					.orElseThrow(() -> new PatientHandlingException("Invalid Patient ID")).getPatientName());
			temp.setDiagnosis(obj.getDiagnosis().toString());
			temp.setPrecDec(obj.getPrescription().toString());
			temp.setPrecDate(obj.getPrescriptionDate());
			list.add(temp);
			System.out.println("temp");
			System.out.println("list");
		});
		return list;
	}

	@Override
	public List<Prescription> getPrescriptionBypcpidAndpid(Integer prescptionId, Integer patientId) {
		// TODO Auto-generated method stub

		return PrecRepo.findByPrescptionIdAndPatientId(prescptionId, patientId);
	}

	@Override
	public Prescription getPrecsptionById(Integer precpId) {
		// TODO Auto-generated method stub
		return PrecRepo.findById(precpId).orElseThrow(() -> new DoctorException("Invalid Prescription Id"));
	}

	@Override
	public List<Prescription> getPrescriptionBypidAnddocId(Integer patientId, Integer doctorId) {
		// TODO Auto-generated method stub
		return PrecRepo.findByPatientIdAndDoctorId(patientId, doctorId);
	}

	@Override
	public List<Appointment> getAllAppointments() {
		// TODO Auto-generated method stub
		patRepo.findAll();
		DocRepo.findAll();
		return appRepo.findAll();
	}


	@Override
	public String assignDepartmentToDoctor(Department dept, Integer docId) {
		// TODO Auto-generated method stub
		doctorRepo.setDoctorDepartment(dept, docId);
		
		return "Assigned dept id:"+dept.getId()+" to docid : "+docId;
	}

		

}
