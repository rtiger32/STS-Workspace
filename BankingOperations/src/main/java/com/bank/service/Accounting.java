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

	public Accounting(User user) {
		this.user = user;
	}

	private void wait(int num) {

		try {
			Thread.sleep(num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void accounting(List<Account> accounts) throws FileNotFoundException {
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
						+ "\n2) Withdraw funds\n3) Transfer funds to another account"
						+ "\n4) Change Password\n5) Logout");

				if (user.getExec() != 0) {
					System.out.println("6) Open a new banking account \n7) View a specific account "
							+ "\n8) View the system log\n9) Delete an account\n10) Add an employee");

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
					wait(3000);
					break;
				case 2: // withdraw
					dep = acctChk(accounts, true, true);
					if (dep == null)
						continue;
					dep.showBalance();
					dep.makeWithdrawl();
					wait(3000);
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
					wait(3000);
					break;
				case 4:
					Password pass = new Password();
					if (pass.change(user.getuName())) {
						return;
					} else {
						break;
					}
				case 5: // logout
					System.out.println("Have a nice day");
					Logging.logger.info(user.getuName() + "has logged out");
					wait(3000);
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

					BufferedReader rin = new BufferedReader(new FileReader(
							"c:/users/rpeng/desktop/eclipse/sts workspace/bankingoperations/src/log.txt"));
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
				case 9:
					if (user.getExec() != 2) {
						System.out.println("Invalid entry. Try again.");
						break;
					}
					System.out.println("Enter the user to remove");
					String rem = in.nextLine();
					User rmuser = udao.getUser(rem);
					if (rmuser.getExec() == 2) {
						System.out.println("You are not authorized to perform this operation");
						Logging.logger.warn(user.getuName() + " has attempted to delete Manager " + rem);
					} else {
						udao.removeUserByUsername(rem);
						System.out.println("User " + rem + " has been deleted");
						Logging.logger.warn("Manager " + user.getuName() + " has deleted User " + rem);
					}
					wait(3000);
					break;
				case 10:
					if (user.getExec() != 2) {
						System.out.println("Invalid entry. Try again.");
						break;
					}
					System.out.println("Enter the user to change permissions");
					String el = in.nextLine();
					User eluser = udao.getUser(el);
					if (eluser.getExec() == 2) {
						System.out.println("You are not authorized to perform this operation");
						Logging.logger.warn(user.getuName() + " has attempted to alter permissions on Manager " + el);
					} else {

						System.out.println("Change status to:\n1) User \n2) Employee");
						int ex;
						try {
							ex = Integer.parseInt(in.nextLine());
							ex--;
						} catch (Exception e) {
							ex = 0;
						}
						System.out.print("Status of " + el + " has been changed to ");
						if (ex == 1)
							System.out.println("Employee");
						else {
							ex = 0;
							System.out.println("User");
						}
						udao.setExec(eluser, ex);
						Logging.logger.warn(
								"Manager " + user.getuName() + " has changed" + eluser.getuName() + " to level " + ex);
					}
					wait(3000);
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