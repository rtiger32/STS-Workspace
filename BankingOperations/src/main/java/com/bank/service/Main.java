package com.bank.service;

import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.model.User;

public class Main {

	public static void main(String[] args) {
		User user = welcome();
		System.out.println("Welcome "+ user.getfName());
	}

private static User welcome() {
	
	while (true) {
	UserDAOImpl udao = new UserDAOImpl();
	System.out.println("Welcome to our bank");
	System.out.println("\nPress 1 to Login, Press 2 to Signup");
	Scanner in = new Scanner(System.in);
	int select = in.nextInt();
	
	switch (select) {
	case 1:
		int count = 0;
		while(count != 4) {
			count++;
			System.out.println("\nPlease enter your username: ");
				String choice = in.nextLine();
			User signin = udao.getUser(choice);
			if (signin == null) {
				System.out.println("I could not find that username. Try again.");
				continue;
			} else {
				System.out.println("Please enter your password: ");
				if (in.nextLine().equals(signin.getPassword())) {
					return signin;
				} else {
					System.out.println("Incorrect password, Try again");
				} 
			} 				
		}
		continue;
	default:
		continue;
		}
	
	}
}
}