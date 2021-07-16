package com.bank.service;

import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.logging.Logging;
import com.bank.model.User;

public class Welcome {
	
	public Welcome() {
		
	}
	public User init() {

		Scanner in = new Scanner(System.in);
		UserDAOImpl udao = new UserDAOImpl();

		while (true) {
			for (int i = 0; i != 60; i++) {
			System.out.println();
			}
			System.out.println("\n\nWelcome to our bank");
			System.out.println("\nPress 1 to Login, Press 2 to Signup");
			int select;
			try {
				select = Integer.parseInt(in.nextLine());
			} catch (Exception e) {
				select = 0;
			}
			switch (select) {
			case 1: // run the login code
				int count = 0;
				while (count != 3) {
					count++;
					System.out.println("\nPlease enter your username: ");
					String choice = in.nextLine();
					User signin = udao.getUser(choice);
					System.out.println("Please enter your password: ");
					if (in.nextLine().equals(signin.getPassword())) {
						return signin; // if the username and password is valid, return the user object
					} else {
						System.out.println("Sorry, Try again");
						Logging.logger.debug("User "+ choice + " failed to authenticate");
					}
				}
				Logging.logger.warn("A user did not authenticate");
				System.out.println("You are not authorized to access this system."
						+ " \nSee a staff member if you need assistance.");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("\n\n\n\n\n\n");
				break;

			case 2:
				NewUser newuser = new NewUser();
				newuser.init();
				//newUser();
				break;
			case -42:// quit the program
				Logging.logger.warn("The program was terminated");
				System.exit(0);
			default:
				break;
			}

		}
	}
}
