package com.bank.service;

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
	UserDAOImpl udao = new UserDAOImpl();
	Scanner in = new Scanner(System.in);


	public Accounting(User user) {
		this.user = user;

	}

	
	public void acctCheck() {
		// Check to see if the user has an account
		if (user.getExec() == 0)
			Logging.logger.info("User " + user.getuName() + " has logged in");
		else
			Logging.logger.info("Employee " + user.getuName() + " has logged in");
		List<Account> accounts = udao.viewAcct(user);
		
		for (int i = 0; i != 60; i++) {
		System.out.println();
		}
		System.out.println("Welcome " + user.getfName() + " " + user.getlName()+ "\n");

		// If the user has no account, tell them to go find a staff member
		if (accounts.isEmpty() && user.getExec() == 0) {

			Logging.logger.info(user.getuName() + " has no active accounts");
			System.out.println("You currently have no accounts with our bank. \n "
					+ "Please see one of our representitives to open a new account.");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			// Otherwise, lets do business
		} else {
			accounting(accounts);
		}
	}

	public void accounting(List<Account> accounts) {
		// The user has an account, or is an employee
		List<String> acct = new ArrayList<>();

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
			int select;
			while (true) {
				System.out.println("\nWhat would you like to do:\n1) Make a deposit"
						+ "\n2) Withdraw funds\n3) Transfer funds to another account" + "\n4) Logout");

				try {
				select = Integer.parseInt(in.nextLine());
				}catch (Exception e) {
					select = 0;
				}

				Deposit dep = new Deposit();
				switch (select) {
				case 1:
					dep = acctchk(acct);
					if (dep == null)
						continue;
					// run the deposit code
					dep.makeDeposit();
					break;
				case 2:
					dep = acctchk(acct);
					if (dep == null)
						continue;
					// run the deposit code in negative
					dep.makeWithdrawl();
					break;
				case 3:
					dep = acctchk(acct);
					if (dep == null)
						continue;
					// run the transfer code
					dep.makeTransfer();
					break;
				case 4:
					System.out.println("Have a nice day");
					Logging.logger.info(user.getuName() + "has logged out");
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					return;
				default:
					System.out.println("Invalid entry. Try again.");
					continue;
				}

			}
		}
	}

	private Deposit acctchk(List<?> acct) {
		System.out.println("From which account:");
		String check = in.nextLine();
		Deposit dep = new Deposit(check);
		if (!acct.contains(check)) {
			System.out.println("I do not recognize that account, try again");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return null;
		}
		return dep;
	}
}
