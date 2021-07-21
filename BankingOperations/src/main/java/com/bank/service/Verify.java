package com.bank.service;

import java.io.FileNotFoundException;
import java.util.List;

import com.bank.dao.UserDAOImpl;
import com.bank.logging.Logging;
import com.bank.model.Account;
import com.bank.model.User;

public class Verify {
	
	private UserDAOImpl udao = new UserDAOImpl();

	public void acctCheck(User user) {
		// Check to see if the user has an account
		if (user.getExec() == 0)
			Logging.logger.info("User " + user.getuName() + " has logged in");
		else
			Logging.logger.info("Employee " + user.getuName() + " has logged in");
		List<Account> accounts = udao.viewAcct(user);

		for (int i = 0; i != 60; i++) {
			System.out.println();
		}
		System.out.println("Welcome " + user.getfName() + " " + user.getlName() + "\n");

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
			Accounting act = new Accounting(user);
			try {
				act.accounting(accounts);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
