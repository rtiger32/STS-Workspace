package com.examples.exceptions;

public class UserNameAlreadyExistsException extends RuntimeException{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameAlreadyExistsException() {
		super("The username already exists");
	}

}
