package com.ehospital.servicelayer_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.pojos.Medicine;
import com.ehospital.repository.MedicineRepository;
import com.ehospital.service.IMedicineService;

@SpringBootTest
class IMedicineServiceTest {

	
	@Autowired 
	private IMedicineService medicineService;
	
	
//	@Test
//	void testAddMedicine() {
//		Medicine newMedicine1=new Medicine("Linctus", 50,78.56 );
//		medicineService.addMedicine(newMedicine1);
//		assertEquals(medicineService.getAllMedicines().size(),5);
//	}
	

	
	@Test
	void testUpdateMedicineDetails()
	{
		medicineService.updateMedicineDetails(140, 1);
		assertEquals(medicineService.getMedicineById(1).getQuantity(), 140);
	}
	

	
//	@Test
//	void testDeleteMedicine()
//	{
//		
//		medicineService.deleteMedicineById(5);
//		assertEquals(medicineService.getAllMedicines().size(), 5);
//	}

}
