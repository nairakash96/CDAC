package com.ehospital.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ehospital.customexception.ReportException;
import com.ehospital.filehandling.ResponseFile;
import com.ehospital.filehandling.ResponseMessage;
import com.ehospital.pojos.BasicReportDetails;
import com.ehospital.pojos.Report;
import com.ehospital.service.IReportService;

@RestController
@CrossOrigin("*")
@RequestMapping("/report")
public class Lab_Incharge_Controller {

	@Autowired
	private IReportService reportService;

	public Lab_Incharge_Controller() {
		System.out.println(" In constr of " + getClass().getName());
	}

	@GetMapping
	public List<BasicReportDetails> getAllBasicReportDetails() {
		return reportService.getAllBasicReports();
	}

	@PostMapping
	public ResponseEntity<?> createBasicReport(@RequestBody BasicReportDetails basicReport) {
		System.out.println("In controller - createBasicReport");
		return new ResponseEntity<>(reportService.addBasicReport(basicReport), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{rid}")
	public ResponseEntity<String> deleteBasicReport(@PathVariable Integer rid)
	{
		System.out.println("In controller - deleteBasicReport");
		return ResponseEntity.ok(reportService.deleteBasicReport(rid));
	}

	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam String reportId, @RequestParam String patientId,@RequestParam String rdate) {
		String message = "";
		try {
			System.out.println(file.getOriginalFilename());
			String ext=(file.getOriginalFilename().substring(file.getOriginalFilename().length()-4, file.getOriginalFilename().length()));
			if(!ext.equals(".pdf"))
			{
				message="File should be in .pdf format only";
			}
			else
			{
				reportService.storeReport(file, Integer.parseInt(reportId), Integer.parseInt(patientId), LocalDate.parse(rdate));

				message = "Uploaded the file successfully: " + file.getOriginalFilename();
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}

	@GetMapping(value = "/files/{id}", produces = "application/pdf")
	public ResponseEntity<byte[]> getFile(@PathVariable Integer id) {
		System.out.println("in get file");
		Report report = reportService.getReport(id);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + report.getId() + "\"")
				.body(report.getReportDesc());
	}

	@GetMapping("/filesByPatientId")
	public ResponseEntity<List<ResponseFile>> getListFilesByPatientID(@RequestParam Integer pid) {
		System.out.println("In filesByPatientID");
		List<ResponseFile> files = reportService.getAllReportsByPatientId(pid).stream().map(patientReportDetails -> {
			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("report/files/")
					.path(patientReportDetails.getId().toString()).toUriString();

			return new ResponseFile(patientReportDetails.getId(),patientReportDetails.getBasicReportDetails().getReportName(),patientReportDetails.getReportIssueDate(), fileDownloadUri,
					patientReportDetails.getBasicReportDetails().getId(), patientReportDetails.getPatientId().getId(),
					patientReportDetails.getReportDesc().length);
		}).collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
	List<ResponseFile> files = reportService.getAllReports().map(patientReportDetails -> {
	  String fileDownloadUri = ServletUriComponentsBuilder
	      .fromCurrentContextPath()
	      .path("/report/files/")
	      .path(patientReportDetails.getId().toString())
	      .toUriString();
	
	  return new ResponseFile(
	      patientReportDetails.getId(),
	      patientReportDetails.getBasicReportDetails().getReportName(),
	      patientReportDetails.getReportIssueDate(),
	      fileDownloadUri,
	      patientReportDetails.getBasicReportDetails().getId(),
	      patientReportDetails.getPatientId().getId(),
	      patientReportDetails.getReportDesc().length);
	}).collect(Collectors.toList());
	
	return ResponseEntity.status(HttpStatus.OK).body(files);
	}
}
//	@GetMapping("/filesByReportId")
//	  public ResponseEntity<List<ResponseFile>> getListFilesByReportID(@RequestParam Integer rid) {
//	    List<ResponseFile> files = reportService.getAllReportsByReportId(rid).stream().map(patientReportDetails -> {
//	      String fileDownloadUri = ServletUriComponentsBuilder
//	          .fromCurrentContextPath()
//	          .path("/files/")
//	          .path(patientReportDetails.getId().toString())
//	          .toUriString();
//
//	      return new ResponseFile(
//	          patientReportDetails.getId(),
//	          fileDownloadUri,
//	          patientReportDetails.getBasicReportDetails().getId(),
//	          patientReportDetails.getPatientId().getId(),
//	          patientReportDetails.getReportDesc().length);
//	    }).collect(Collectors.toList());
//
//	    return ResponseEntity.status(HttpStatus.OK).body(files);
//	  }
//	
//	@GetMapping("/filesByReportIdAndPatientID")
//	  public ResponseEntity<List<ResponseFile>> getListFilesByReportIDAndPatientID(@RequestParam Integer rid,@RequestParam Integer pid){
//	    List<ResponseFile> files = reportService.getAllReportsByReportIdAndPatientId(rid, pid).stream().map(patientReportDetails -> {
//	      String fileDownloadUri = ServletUriComponentsBuilder
//	          .fromCurrentContextPath()
//	          .path("/files/")
//	          .path(patientReportDetails.getId().toString())
//	          .toUriString();
//
//	      return new ResponseFile(
//	          patientReportDetails.getId(),
//	          fileDownloadUri,
//	          patientReportDetails.getBasicReportDetails().getId(),
//	          patientReportDetails.getPatientId().getId(),
//	          patientReportDetails.getReportDesc().length);
//	    }).collect(Collectors.toList());
//
//	    return ResponseEntity.status(HttpStatus.OK).body(files);
//	  }
//	

