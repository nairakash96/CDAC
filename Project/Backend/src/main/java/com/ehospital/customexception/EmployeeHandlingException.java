package com.ehospital.customexception;

@SuppressWarnings("serial")
public class EmployeeHandlingException extends RuntimeException {
	public EmployeeHandlingException(String mesg) {
		super(mesg);
	}
}
