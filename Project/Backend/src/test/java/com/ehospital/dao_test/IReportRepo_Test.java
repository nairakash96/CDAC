package com.ehospital.dao_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.pojos.BasicReportDetails;
import com.ehospital.repository.IBasicReportRepository;
import com.ehospital.repository.IReportRepository;
import com.ehospital.service.IReportService;

@SpringBootTest
class IReportRepo_Test {

	
	@Autowired
	private IBasicReportRepository basicReportRepository;
	
	@Autowired
	private IReportRepository reportRepository;
	
	@Autowired
	private IReportService reportService;
	
	@Test
	void testAddBasicReportDetails()
	{
		List<BasicReportDetails> basicReportList=Arrays.asList(
				new BasicReportDetails("CT-Scan"),
				new BasicReportDetails("Sonography"),
				new BasicReportDetails("X-Ray"),
				new BasicReportDetails("MRI")
				);
		
		basicReportRepository.saveAll(basicReportList);
		
		assertEquals(basicReportRepository.findAll().size(), 4);
				
	}
	
//	@Test
//	void testDeleteBasicReportDetails()
//	{
//		basicReportRepository.deleteById(2);
//		assertEquals(basicReportRepository.findAll().size(), 2);
//	}
	
//	@Test
//	void testAddPatientReport() throws IOException
//	{
//		 String filePath = "C:\\Users\\Chaitali\\Desktop\\TestPatientReport2.pdf";
//		 File file = new File(filePath);
//		 FileInputStream fis=new FileInputStream(file);
//		 MultipartFile mfile=new MockMultipartFile("patientreport", file.getName(), "text/plain", fis.readAllBytes());
//		 reportService.storeReport(mfile, 3, 1, LocalDate.now());
//		 assertEquals(reportRepository.findAll().size(), 1);
//	}

}
