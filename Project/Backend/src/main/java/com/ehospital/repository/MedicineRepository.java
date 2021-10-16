package com.ehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;

import com.ehospital.pojos.Medicine;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Integer>{


	//@Transactional //can be removed from here as we are going to add it in service layer
	@Modifying(flushAutomatically = true,clearAutomatically = true)
	//Modifying--can be used with INSERT,UPDATE,DELETE queries
	//clearAutomatically--clears the persistence context after query execution
	//flushAutomatically--flushes out the entityManager before query execution
	@Query("update Medicine  set quantity=:updatedQuantity  where id=:medId")
	void  updateMedicineDetails(@Param("updatedQuantity") int  quantity,@Param("medId") Integer medicineId);
	
	
		
	

}
