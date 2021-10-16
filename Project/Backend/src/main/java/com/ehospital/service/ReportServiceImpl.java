package com.ehospital.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ehospital.customexception.PatientHandlingException;
import com.ehospital.customexception.ReportException;
import com.ehospital.pojos.BasicReportDetails;
import com.ehospital.pojos.Patient;
import com.ehospital.pojos.Report;
import com.ehospital.repository.IBasicReportRepository;
import com.ehospital.repository.IReportRepository;
import com.ehospital.repository.PatientRepository;

@Service
@Transactional
public class ReportServiceImpl implements IReportService {
	
	@Autowired
	private IReportRepository reportRepo;
	@Autowired
	private IBasicReportRepository basicReportRepo;
	
	@Autowired
	private PatientRepository patientRepo;

	@Override
	public BasicReportDetails addBasicReport(BasicReportDetails newBasicReport) {
		// TODO Auto-generated method stub
		return basicReportRepo.save(newBasicReport);
	}
	
	@Override
	public String deleteBasicReport(Integer reportId) {
		// TODO Auto-generated method stub
		basicReportRepo.deleteById(reportId);
		return "Report type deleted Successfully";
	}

	@Override
	public 	Report storeReport(MultipartFile file,Integer reportId,Integer patientId,LocalDate report_issue_date) throws IOException
{
		// TODO Auto-generated method stub
		BasicReportDetails basicReportDetails=basicReportRepo.findById(reportId).orElseThrow(()->new ReportException("Invalid Report ID"));
		Patient patient=patientRepo.findById(patientId).orElseThrow(()->new PatientHandlingException("Invalid Patient ID"));
		Report newReport=new Report(basicReportDetails, patient, file.getBytes(), report_issue_date);
		return reportRepo.save(newReport);
		
	}


	

	@Override
	public Report getReport(Integer id) {
	    return reportRepo.findById(id).get();
	  }

	@Override
	public List<Report> getAllReportsByPatientId(Integer patientId) {
		// TODO Auto-generated method stub
		return reportRepo.findByPatientId(patientRepo.getById(patientId));
	}

	@Override
	public List<BasicReportDetails> getAllBasicReports() {
		// TODO Auto-generated method stub
		return basicReportRepo.findAll();
	}

	@Override
	public Stream<Report> getAllReports() {
		// TODO Auto-generated method stub
		return reportRepo.findAll().stream();
	}





}
