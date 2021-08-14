package com.app.core;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Student implements Comparable<Student> {
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
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Student [prn=" + prn + ", name=" + name + ", email=" + email + ", password=" + password + ", GPA=" + GPA
				+ ", course=" + course + ", DOB=" + sdf.format(DOB) + "]";
	}
	public boolean equals (Object o) {
		if(o instanceof Student)
			return prn.equals(((Student) o).prn);
		return false;
	}
	public void setGPA(double gPA) {
		this.GPA = gPA;

	}
	public String getPrn() {
		return prn;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public double getGPA() {
		return GPA;
	}
	public Course getCourse() {
		return course;
	}
	public Date getDOB() {
		return DOB;
	}
	public static SimpleDateFormat getSdf() {
		return sdf;
	}
	
	public int compareTo(Student anotherStudent)
	{
		//System.out.println("in acct's compareTo");
//		if(this.GPA < anotherStudent.GPA)
//			return -1;
//		if(this.GPA == anotherStudent.GPA)
//			return 0;
//		return 1;
		return((Double)GPA).compareTo(anotherStudent.GPA);
	}
	

}
