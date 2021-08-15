package com.luv2code.exc;

public class StudentNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public StudentNotFoundException() {
	}

	public StudentNotFoundException(String message) {
		super(message);
	}
	
}
