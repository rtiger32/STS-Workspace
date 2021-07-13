package com.bank.exception;

public class InvalidAuthorizationException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAuthorizationException() {
		System.out.println("User tried gaining access with invalid credentials.");
	}

}
