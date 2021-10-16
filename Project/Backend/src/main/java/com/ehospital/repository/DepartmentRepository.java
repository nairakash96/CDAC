package com.ehospital.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ehospital.pojos.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer>{

//	update department details by id
	@Modifying
	@Query("update Department d set d.departmentName = ?1 where d.id = ?2")
	int setDepartmentDetailsById(String departmentName, int id );
}
