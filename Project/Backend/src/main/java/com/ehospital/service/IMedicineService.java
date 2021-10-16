package com.ehospital.service;

import java.util.List;
import com.ehospital.pojos.Medicine;


public interface IMedicineService {

	Medicine addMedicine(Medicine newMedicine);
	String deleteMedicineById(Integer medicineId);
	String updateMedicineDetails(int quantity,Integer medicineId);
	List<Medicine> getAllMedicines();
	Medicine getMedicineById(Integer medicineId);
	
}
