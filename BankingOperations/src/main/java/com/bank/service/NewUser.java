package com.bank.service;

import java.util.Random;

import com.bank.model.User;

public class NewUser {

	public NewUser() {
		
	}
	
	public NewUser(String fName, String lName, String password) {
		
		//User u = new User(fName,lName,Integer.toString(new Random().nextInt(99000) + 1000));
	
		User u = new User(fName, lName, password);
		//add user to database if there is no match
		
		// if the user database is empty. add exec
		
		
		
		
	}
}
	
	
