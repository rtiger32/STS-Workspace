package com.bank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.model.Account;
import com.bank.model.User;

public class Main {

	public static void main(String[] args) {

		while (true) {
			User user = welcome();
			System.out.println("Welcome " + user.getfName() + " " + user.getlName());
			acctCheck(user);
		}
	}

	private static void acctCheck(User user) {
		// Check to see if the user has an account
		UserDAOImpl udao = new UserDAOImpl();
		List<Account> accounts = udao.viewAcct(user);

		// If the user has no account, tell them to go find a staff member
		if (accounts.isEmpty() && user.getExec() == 0) {
			System.out.println("You currently have no accounts with our bank. \n "
					+ "Please see one of our representitives to open a new account.");
			try {
				Thread.sleep(15000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Otherwise, lets do business
		} else {
			accounting(user, accounts);
		}
	}

	private static void accounting(User user, List<Account> accounts) {
		// The user has an account, or is an employee

		Scanner in = new Scanner(System.in);
		if (accounts.isEmpty()) {
			System.out.println("You have no accounts with our bank");
		} else {
			Account u = new Account();
			for (int i = 0; i < accounts.size(); i++) {
				u = accounts.get(i);
				System.out.println("\nAccount number: " + u.getAcctNum() + "\nBalance: " + u.getBalance());
			}
			System.out.println("\nWhat would you like to do:\n1) Make a deposit"
					+ "\n2) Withdraw funds\n3) Transfer funds to another account");
			int select = Integer.parseInt(in.nextLine());
			switch (select) {
			case 1:
				// run the deposit code
				break;
			case 2:
				// run the deposit code in negative
				break;
			case 3:
				// run the transfer code
			default:
			}
		}
	}

	private static User welcome() {

		Scanner in = new Scanner(System.in);
		UserDAOImpl udao = new UserDAOImpl();

		while (true) {
			System.out.println("\n\nWelcome to our bank");
			System.out.println("\nPress 1 to Login, Press 2 to Signup");

			int select = Integer.parseInt(in.nextLine());

			switch (select) {
			case 1: //run the login code
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
					}
				}
				System.out.println("You are not authorized to access this system."
						+ " \nSee a staff member if you need assistance.");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("\n\n\n\n\n\n");
				break;

			case 2: //run the signup code
				break;
			case -42://quit the program
				System.exit(0);
			default:
				break;
			}

		}
	}
}