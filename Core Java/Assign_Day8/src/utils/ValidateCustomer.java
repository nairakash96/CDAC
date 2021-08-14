package utils;



import static com.app.core.CustType.valueOf;
import static com.app.core.Customer.sdf;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import com.app.core.CustType;
import com.app.core.Customer;
import com.app.exception.CustomerHandlingException;

public class ValidateCustomer {
	
	private static Date testDate;
	static {
		try {
			testDate = sdf.parse("1-1-1995");
		} catch (ParseException e) {
			System.out.println("Error in static init block " + e);
		}
	}
	
	public static Date ValidateDOB(String date) throws ParseException, CustomerHandlingException {
		Date d1 = sdf.parse(date);
		if (d1.before(testDate))
			throw new CustomerHandlingException("Invalid Date...");
		return d1;

	}
	
	
	public static CustType ValidateCustType(String custtype) throws CustomerHandlingException {
		try {
			return valueOf(custtype.toUpperCase());
		} catch (IllegalArgumentException e) {
			StringBuilder sb = new StringBuilder("Invalid CustType chosen!!!!!\n Available Plans : ");
			sb.append(Arrays.toString(CustType.values()));
			throw new CustomerHandlingException(sb.toString());
		}
	}
	
	
	public static String ValidateEmail(String email) throws CustomerHandlingException{
		if(!(email.contains("@") && email.endsWith(".com"))) {
			throw new CustomerHandlingException("Your email id should contain @ and .com");
		}
		return email;
	}
	
	public static String ValidatePassword(String password) throws CustomerHandlingException{
		if(!(password.length()>=4 && password.length()<=10)) {
			throw new CustomerHandlingException("Password should be more than 4 and less than 10");
		}
		return password;
	}
	
	public static double ValideRegAmount(double registrationAmount) throws CustomerHandlingException{
		if(!(registrationAmount%500==0)) {
			throw new CustomerHandlingException("registrationAmount should be multiple of 500");
		}
		return registrationAmount;
	}
	
	public static String checkForDuplication(String email,Customer[] customer) throws CustomerHandlingException
	{
		Customer testCustomer=new Customer(email);
		for(Customer v : customer)
			if(v != null)
				if(v.equals(testCustomer))
		throw new CustomerHandlingException("Invalid Email : Duplicate email found!!!!!!");
		return email;
		
	}

}
