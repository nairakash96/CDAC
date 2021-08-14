package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	private String name;
	private String email;
	private String password;
	private double registrationAmount;
	private Date DOB;
	private CustType CostomerType;
	
	public Customer(String name, String email, String password, double registrationAmount, Date DOB,
			CustType costomerType) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.registrationAmount = registrationAmount;
		this.DOB = DOB;
		CostomerType = costomerType;
	}
	
public static SimpleDateFormat sdf;
	
	static  {
		 sdf=new SimpleDateFormat("dd-MM-yyyy");
	}
	
	public Customer(String email) {
		super();
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", email=" + email + ", password=" + password + ", registrationAmount="
				+ registrationAmount + ", DOB=" + sdf.format(DOB) + ", CostomerType=" + CostomerType + "]";
	}
	
	@Override
	public boolean equals(Object anotherCustomer) {
		System.out.println("in custmor's eq");
		if (anotherCustomer instanceof Customer)
			return email.equals(((Customer) anotherCustomer).email);
		return false;
	}
	
	
	
	
}
