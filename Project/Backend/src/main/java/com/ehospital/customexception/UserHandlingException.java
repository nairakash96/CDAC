package com.ehospital.customexception;

@SuppressWarnings("serial")
public class UserHandlingException extends RuntimeException {
	public UserHandlingException(String mesg) {
		super(mesg);
	}
}
