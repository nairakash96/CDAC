package com.ehospital.customexception;

@SuppressWarnings("serial")
public class DepartmentHandlingException extends RuntimeException {
	public DepartmentHandlingException(String mesg) {
		super(mesg);
	}
}
