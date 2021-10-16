package com.ehospital.dao_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.pojos.Medicine;
import com.ehospital.repository.MedicineRepository;

@SpringBootTest
class IMedicineRepoTest {

	
	@Autowired
	private MedicineRepository medicineDao;
	
	@Test
	void testAddMedicine() {
		List<Medicine> medicinelist=Arrays.asList(
				new Medicine("Augmentin 625 Duo",500),
				new Medicine("Benadryl Syrup",200),
				new Medicine("Crocin",150),
				new Medicine("Paracetamol",500),
				new Medicine("Zincovit",75)
				);
		medicineDao.saveAll(medicinelist);
		assertEquals(medicineDao.findAll().size(),5);
	}
		
//	@Test
//	void testUpdateMedicineDetails()
//	{
//		medicineDao.updateMedicineDetails(120, 2,12);
//		assertEquals(medicineDao.findAll().size(), 5);
//	}
	

	
//	@Test
//	void testDeleteMedicine()
//	{
//		medicineDao.deleteById(4);
//		assertEquals(medicineDao.findAll().size(), 4);
//	}

}
