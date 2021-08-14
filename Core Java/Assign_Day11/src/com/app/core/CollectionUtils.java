package com.app.core;

import java.text.ParseException;
import java.util.ArrayList;

import custom_exception.StudentException;

import static com.app.core.Course.*;
import static utils.Validation.*;

public class CollectionUtils {
	
	
	
	public static Student verifyAccount(String prn, ArrayList<Student> accts, String errMesg)
			throws StudentException {
		int index = accts.indexOf(new Student(prn));//invoke internally in the loop:equals methord
		if (index == -1)
			throw new StudentException(errMesg);
		// AL method : public E get(int index)
		return accts.get(index);
	}
	
	
	public static ArrayList<Student> populateSampleData() {
		ArrayList<Student> list = new ArrayList<>();
		try {
			list.add(new Student("101","Rama","rama@123.com","rama@123",9.8,DBT,convertDate("2-3-2020")));
			list.add(new Student("102", "Raj", "raj@123.com","raj@123",8.8,HIBERNATE,convertDate("22-6-2000")));
			list.add(new Student("103", "Rohan", "rohan@123.com","rohan@123",7.8,REST,convertDate("28-03-1920")));
			list.add(new Student("104", "Surash", "surash@123.com","surash@123",8.6,SPRING,convertDate("12-3-1993")));
			list.add(new Student("105", "Akash", "akash@123.com","akash@123",9.5,ANGULAR,convertDate("22-03-1997")));
			list.add(new Student("106", "Vijay", "vijay@123.com","vijay@123",9.3,REST,convertDate("2-3-2020")));
			
		} catch (ParseException e) {
			System.out.println("err in sample data " + e);
		}
		return list;
	}
}