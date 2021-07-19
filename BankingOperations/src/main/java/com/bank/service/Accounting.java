package com.bank.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.logging.Logging;
import com.bank.model.Account;
import com.bank.model.Log;
import com.bank.model.User;

public class Accounting {

	private User user = new User();
	private UserDAOImpl udao = new UserDAOImpl();
	private Scanner in = new Scanner(System.in);
//	private List<Account> accounts;

	public Accounting(User user) {
		this.user = user;
//		this.accounts = accounts;
	}

//	public void acctCheck() {
//		// Check to see if the user has an account
//		if (user.getExec() == 0)
//			Logging.logger.info("User " + user.getuName() + " has logged in");
//		else
//			Logging.logger.info("Employee " + user.getuName() + " has logged in");
//		List<Account> accounts = udao.viewAcct(user);
//
//		for (int i = 0; i != 60; i++) {
//			System.out.println();
//		}
//		System.out.println("Welcome " + user.getfName() + " " + user.getlName() + "\n");
//
//		// If the user has no account, tell them to go find a staff member
//		if (accounts.isEmpty() && user.getExec() == 0) {
//
//			Logging.logger.info(user.getuName() + " has no active accounts");
//			System.out.println("You currently have no accounts with our bank. \n "
//					+ "Please see one of our representitives to open a new account.");
//			try {
//				Thread.sleep(10000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//
//			// Otherwise, lets do business
//		} else {
//			accounting(accounts);
//		}
//	}

	public void accounting(List<Account> accounts) {
		// The user has an account, or is an employee

		if (accounts.isEmpty()) {
			Logging.logger.info(user.getuName() + " has no active accounts");
			System.out.println("You have no accounts with our bank");
		} else {
			while (true) {
				for (int i = 0; i != 60; i++) {
					System.out.println();
				}
				accounts = udao.viewAcct(user); // update the accounts list
				Account u = new Account();
				for (int i = 0; i < accounts.size(); i++) {
					u = accounts.get(i);
					System.out.println("\nAccount number: " + u.getAcctNum() + "\nBalance: " + u.getBalance());
				}
				int select;

				System.out.println("\nWhat would you like to do:\n1) Make a deposit"
						+ "\n2) Withdraw funds\n3) Transfer funds to another account" + "\n4) Logout");

				if (user.getExec() != 0) {
					System.out.println(
							"6) ADMIN: Open a new banking account \n7) ADMIN View a specific account \n8) ADMIN View the system log");

				}
				try {
					select = Integer.parseInt(in.nextLine());
				} catch (Exception e) {
					select = 0;
				}

				Deposit dep = new Deposit();
				switch (select) {
				case 1: // deposit
					dep = acctChk(accounts, true, false);
					if (dep == null)
						continue;
					dep.showBalance();
					dep.makeDeposit();
					break;
				case 2: // withdraw
					dep = acctChk(accounts, true, true);
					if (dep == null)
						continue;
					dep.showBalance();
					dep.makeWithdrawl();
					break;
				case 3: // transfer
					dep = acctChk(accounts, true, true);
					if (dep == null)
						continue;
					Deposit dep2 = acctChk(accounts, false, false);
					if (dep2 == null)
						continue;
					dep.showBalance();
					dep.makeTransfer(dep2);
					break;
				case 4: // logout
					System.out.println("Have a nice day");
					Logging.logger.info(user.getuName() + "has logged out");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return;
				case 6:// new bank account
					if (user.getExec() == 0) {
						System.out.println("Invalid entry. Try again.");
						break;
					}
					NewAcct na = new NewAcct();
					na.openAccount();
					break;
				case 7:// view any account
					if (user.getExec() == 0) {
						System.out.println("Invalid entry. Try again.");
						break;
					}
					MasterSearch ms = new MasterSearch();
					ms.search();
					break;
				case 8:
					if (user.getExec() == 0) {
						System.out.println("Invalid entry. Try again.");
						break;
					}
					BufferedReader rin = new BufferedReader(null);
					try {
						rin = new BufferedReader(new FileReader("log.txt"));
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
					String line;
					try {
						while ((line = rin.readLine()) != null) {
							System.out.println(line);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					System.out.println("Press any key");
					in.nextLine();
					break;
				default:
					System.out.println("Invalid entry. Try again.");
					continue;
				}// end of switch
			} // end of while
		} // end of else
	}// end of method

	private Deposit acctChk(List<Account> accounts, boolean b, boolean c) {
		// Find what account on the list the user wants to manipulate, and return it.
		// b: is it your account?

		String check;
		Account acct;
		Deposit dep;
		if (b) {
			if (c) // Withdraw
				System.out.println("From which account:");
			else // Deposit
				System.out.println("To which account:");
			check = in.nextLine();
			for (int i = 0; i < accounts.size(); i++) {
				acct = accounts.get(i);
				if (acct.getAcctNum().equals(check)) {
					dep = new Deposit(acct);
					return dep;
				}
			}
		} else {
			System.out.println("To which account:");
			check = in.nextLine();
			List<Account> trans = udao.viewAcctbyNumber(check);
			for (int i = 0; i < trans.size(); i++) {
				acct = trans.get(i);
				if (acct.getAcctNum().equals(check)) {
					dep = new Deposit(acct);
					return dep;
				}
			}
		}
		System.out.println("Sorry, I did not find that account");
		return null;

	}
}