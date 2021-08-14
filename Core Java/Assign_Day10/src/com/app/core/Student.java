package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Student {
	private String prn;
	private String name;
	private String email;
	private String password;
	private double GPA;
	private Course course;
	private Date DOB;
	
	public static SimpleDateFormat sdf;
	static {
		sdf=new SimpleDateFormat("dd-MM-yyyy");
	}
	public Student(String prn, String name, String email, String password, double GPA, Course course, Date DOB) {
		super();
		this.prn = prn;
		this.name = name;
		this.email = email;
		this.password = password;
		this.GPA = GPA;
		this.course = course;
		this.DOB = DOB;
	}
	public Student(String prn) {
		super();
		this.prn = prn;
	}
	
	
	@Override
	public String toString() {
		return "Student [prn=" + prn + ", name=" + name + ", email=" + email + ", password=" + password + ", GPA=" + GPA
				+ ", course=" + course + ", DOB=" + sdf.format(DOB) + "]";
	}
	@Override
	public boolean equals (Object o) {
		System.out.println("in stud eqls");
		if(o instanceof Student)
			return prn.equals(((Student) o).prn);
		return false;
	}
	public void setGPA(double gPA) {
		this.GPA = gPA;

	}

}
