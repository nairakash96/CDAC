package com.ehospital.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ehospital.pojos.Bed;

@Repository
public interface BedRepository extends JpaRepository<Bed, Integer> {

	//@Transactional
	@Modifying(clearAutomatically = true,flushAutomatically = true)
	@Query("update Bed b set b.status=:updatedStatus where b.id=:bedid")
	void updateBedStatus(@Param("bedid") Integer bid,@Param("updatedStatus") int status);

	@Query("select b from Bed b where b.status=0")
	List<Bed> listAvailableBeds();
}
