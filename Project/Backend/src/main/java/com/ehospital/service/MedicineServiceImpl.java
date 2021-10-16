package com.ehospital.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ehospital.customexception.MedicineHandlingException;
import com.ehospital.pojos.Medicine;
import com.ehospital.repository.MedicineRepository;

@Service
@Transactional
public class MedicineServiceImpl implements IMedicineService {

	@Autowired
	private MedicineRepository medicineRepo;
	
	@Override
	public Medicine addMedicine(Medicine newMedicine) {
		// TODO Auto-generated method stub
		return medicineRepo.save(newMedicine);
	}

	@Override
	public String deleteMedicineById(Integer medicineId) {
		// TODO Auto-generated method stub
		medicineRepo.deleteById(medicineId);
		return "Deleted Medicine successfully";
	}

	@Override
	public String updateMedicineDetails(int quantity,Integer medicineId) {
		// TODO Auto-generated method stub
		medicineRepo.findById(medicineId).orElseThrow(()->new MedicineHandlingException("Medicine ID does not exist!!"));
		medicineRepo.updateMedicineDetails(quantity, medicineId);
			return "Updated Medicine Quantity successfully";
	}


	@Override
	public List<Medicine> getAllMedicines() {
		// TODO Auto-generated method stub
		return medicineRepo.findAll();
	}

	@Override
	public Medicine getMedicineById(Integer medicineId) {
		// TODO Auto-generated method stub
		return medicineRepo.findById(medicineId).orElseThrow(()-> new MedicineHandlingException("Invalid Medicine"));
	}

	

}
