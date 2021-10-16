package com.ehospital.dao_test;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.pojos.HospitalEmployee;
import com.ehospital.pojos.Role;
import com.ehospital.repository.EmployeeRepository;

@SpringBootTest
class EmployeeDaoTests {
	@Autowired
	private EmployeeRepository empRepo;

	@Test
	void testAddUser() {
		
		List<HospitalEmployee> emps=Arrays.asList(new HospitalEmployee( "rst", "rst@g.com", "rst", Role.ADMIN, "1234", "abc_address"),
				new HospitalEmployee( "jkl", "jkl@g.com", "jkl", Role.DOCTOR, "1234", "pqr_address"),
				new HospitalEmployee( "ghj", "ghj@g.com", "ghj", Role.DOCTOR, "1234", "def_address"),
				new HospitalEmployee( "rty", "rty@g.com", "rty", Role.RECEPTIONIST, "1234", "xyz_address"));
		empRepo.saveAll(emps);
		
	}
	

}
