package utils;

import static com.app.core.Student.sdf;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

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
	
	public static Date convertDate(String date) throws ParseException
	{
		return sdf.parse(date);
	}
	
	
}
