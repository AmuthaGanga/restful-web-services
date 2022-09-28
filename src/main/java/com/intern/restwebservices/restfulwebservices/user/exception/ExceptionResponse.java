package com.intern.restwebservices.restfulwebservices.user.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timeStap;
	private String message;
	private String details;
	
	public ExceptionResponse() {
		// TODO Auto-generated constructor stub
	}

	public ExceptionResponse(Date timeStap, String message, String details) {
		this.timeStap = timeStap;
		this.message = message;
		this.details = details;
	}

	/**
	 * @return the timeStap
	 */
	public Date getTimeStap() {
		return timeStap;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the details
	 */
	public String getDetails() {
		return details;
	}
	

}
