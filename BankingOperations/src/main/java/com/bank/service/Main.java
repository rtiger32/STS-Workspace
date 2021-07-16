package com.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.logging.Logging;
import com.bank.model.Account;
import com.bank.model.User;

public class Main {

	public static void main(String[] args) {

		Welcome wel = new Welcome();
		while (true) {
			
			User user = wel.init();
			Accounting act = new Accounting(user);
			act.acctCheck();
//			acctCheck(user);
		}
	}
/*
	private static User welcome() {

		Scanner in = new Scanner(System.in);
		UserDAOImpl udao = new UserDAOImpl();

		while (true) {
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
				newUser();
				break;
			case -42:// quit the program
				System.exit(0);
			default:
				break;
			}

		}
	}
	*/

	private static void acctCheck(User user) {
		// Check to see if the user has an account
		if (user.getExec()==0)
		Logging.logger.info("User " + user.getuName() + " has logged in");
		else
			Logging.logger.info("Employee " + user.getuName() + " has logged in");
		UserDAOImpl udao = new UserDAOImpl();
		List<Account> accounts = udao.viewAcct(user);
		System.out.println("Welcome " + user.getfName() + " " + user.getlName());

		// If the user has no account, tell them to go find a staff member
		if (accounts.isEmpty() && user.getExec() == 0) {

			Logging.logger.info(user.getuName() + " has no active accounts");
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
		List<String> acct = new ArrayList<>();

		Scanner in = new Scanner(System.in);
		if (accounts.isEmpty()) {
			Logging.logger.info(user.getuName() + " has no active accounts");
			System.out.println("You have no accounts with our bank");
		} else {
			Account u = new Account();
			for (int i = 0; i < accounts.size(); i++) {
				u = accounts.get(i);
				acct.add(u.getAcctNum());
				System.out.println("\nAccount number: " + u.getAcctNum() + "\nBalance: " + u.getBalance());
			}
			System.out.println("\nWhat would you like to do:\n1) Make a deposit"
					+ "\n2) Withdraw funds\n3) Transfer funds to another account");
			int select = Integer.parseInt(in.nextLine());
			switch (select) {
			case 1:
				// run the deposit code
				System.out.println("From which account:");
				String check = in.nextLine();
				if (acct.contains(check)) {
					//continue
				} else {
					System.out.println("I do not recognize that account, try again");
				}
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
	/*
	 * private static void newUser() {
	 * 
	 * UserDAOImpl udao = new UserDAOImpl(); Scanner in = new Scanner(System.in);
	 * System.out.
	 * println("\nThank you for choosing our bank.\nWhat is your first name?");
	 * String fName = in.nextLine().toLowerCase();
	 * System.out.println("\nWhat is your Last name?"); String lName =
	 * in.nextLine().toLowerCase();
	 * System.out.println("\nEnter your email address."); String email =
	 * in.nextLine().toLowerCase(); // check to see if username exists String uName
	 * = ""; String clName = ""; if (lName.length() < 5) clName = lName; else clName
	 * = lName.substring(0, 4); System.out.println(clName); uName = fName.charAt(0)
	 * + clName + (new Random().nextInt(9000) + 1000); //
	 * System.out.println(udao.checkUser(uName));
	 * 
	 * System.out.println("Create a Password (Case Sensitive):"); String password =
	 * in.nextLine(); System.out.println("Thank you.\nYour username is: " + uName +
	 * "\n please use this to login"); User u = new User(fName, lName, password,
	 * uName, 0, email); udao.addUser(u); udao.addUser2(u); //System.out.println(u);
	 * }
	 */

}