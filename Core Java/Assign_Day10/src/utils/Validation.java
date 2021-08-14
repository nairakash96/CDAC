package utils;

import java.util.ArrayList;

import com.app.core.Course;
import com.app.core.Student;

import custom_exception.StudentException;

public class Validation {
	
	public static Course ValidateType(String type) throws StudentException {
		return Course.valueOf(type.toUpperCase());
		}
	public static String checkForDuplication(String prn,ArrayList<Student> stud) throws StudentException
	{
		if(stud.contains(new Student(prn)))
		throw new StudentException("Invalid PRN : Duplicate PRN found!!!!!!");
		return prn;
		
	}
}