package com.luv2code.springdemo.exception;

public class CustomerNotFondException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public CustomerNotFondException() {
		super();
	}

	public CustomerNotFondException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CustomerNotFondException(String message, Throwable cause) {
		super(message, cause);
	}

	public CustomerNotFondException(String message) {
		super(message);
	}

	public CustomerNotFondException(Throwable cause) {
		super(cause);
	}
}
