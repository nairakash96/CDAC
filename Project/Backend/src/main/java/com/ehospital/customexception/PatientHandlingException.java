package com.ehospital.customexception;

@SuppressWarnings("serial")
public class PatientHandlingException extends RuntimeException {
	public PatientHandlingException(String mesg) {
		super(mesg);
	}
}
