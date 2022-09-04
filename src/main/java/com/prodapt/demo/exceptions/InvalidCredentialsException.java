package com.prodapt.demo.exceptions;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Component
public class InvalidCredentialsException extends Exception {
	private String message;

	public InvalidCredentialsException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public InvalidCredentialsException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String toString() {
		return "InvalidCredentialsException [message=" + message + "]";
	}

}
	
	
	
	
	
	
