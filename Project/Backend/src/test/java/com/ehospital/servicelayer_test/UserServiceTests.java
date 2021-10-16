package com.ehospital.servicelayer_test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ehospital.pojos.HospitalEmployee;
import com.ehospital.service.IEmployeeService;

@SpringBootTest
class UserServiceTests {
	@Autowired
	private IEmployeeService empService;

	@Test
	public void testFindEmployeeByEmailAndPassword()
	{
		HospitalEmployee emp = empService.authenticateUser("abc@g.com","abc");
		System.out.println(emp);
		assertEquals("abc",emp.getName());
	}
	
	@Test
	public void testFindByEmail()
	{
		boolean present = empService.checkForEmployee("bc@g.com");
		System.out.println(present);
		assertEquals(false,present);
	}
	
	

}
