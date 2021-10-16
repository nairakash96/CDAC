package com.ehospital.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.ehospital.pojos.BasicReportDetails;
import com.ehospital.pojos.Report;

public interface IReportService {
	BasicReportDetails addBasicReport(BasicReportDetails newBasicReport);
	String deleteBasicReport(Integer reportId);
	List<BasicReportDetails> getAllBasicReports();
	Stream<Report> getAllReports();
	Report storeReport(MultipartFile file,Integer reportId,Integer patientId,LocalDate report_issue_date) throws IOException;
	
	List<Report> getAllReportsByPatientId(Integer patientId);

	Report getReport(Integer id);
	}
