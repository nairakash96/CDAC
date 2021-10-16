package com.ehospital.dao_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.pojos.Bed;
import com.ehospital.repository.BedRepository;

@SpringBootTest
class IBedRepoTest {

	
	@Autowired
	private BedRepository bedRepo;
	
	@Test
	void testAddBed() {
		List<Bed> bedlist=Arrays.asList(
				new Bed(0),
				new Bed(0),
				new Bed(0),
				new Bed(0),
				new Bed(0)
				);
		bedRepo.saveAll(bedlist);
		assertEquals(bedRepo.findAll().size(),5);
	}
	

//	@Test
//	void testUpdateBedStatus()
//	{
//		bedRepo.updateBedStatus(5,1);
//		bedRepo.updateBedStatus(1,1);
//		bedRepo.updateBedStatus(3,1);
//		assertEquals(bedRepo.findById(5).orElseThrow().getStatus(), 1);
//	}
	
//	@Test
//	void testDeleteBed()
//	{
//		bedRepo.deleteById(2);
//		assertEquals(bedRepo.findAll().size(), 4);
//	}

//	@Test
//	void testAvailableBeds()
//	{
//		bedRepo.listAvailableBeds().forEach(System.out::println);;
//		assertEquals(bedRepo.listAvailableBeds().size(), 1);
//	}
}
