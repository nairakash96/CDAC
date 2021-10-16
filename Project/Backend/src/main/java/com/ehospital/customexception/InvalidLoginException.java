package com.ehospital.customexception;

@SuppressWarnings("serial")
public class InvalidLoginException extends RuntimeException {
	public InvalidLoginException(String mesg) {
		super(mesg);
	}
}
