package com.ehospital.customexception;

public class ReportException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	public ReportException(String message) {
		super(message);
	}

}
