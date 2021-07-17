package com.bank.service;

import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.logging.Logging;
import com.bank.model.Account;
import com.bank.model.User;

public class NewAcct {
	private Scanner in = new Scanner(System.in);
	private UserDAOImpl udao = new UserDAOImpl();

	public void openAccount() {
		System.out.println("Enter the userID you wish to open an account for");
		String uname = in.nextLine();
		User user = udao.getUser(uname);
		if (!uname.equals(user.getuName())) {
			System.out.println("That user was not found in the system. \nTell the client to make an account.");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
			return;
		}
		int count = udao.countAccounts();
		int nN = 1000000000 + count;
		String nNum = Integer.toString(nN);
		String acctNum = nNum.substring(0, 5) + " " + nNum.substring(5, 10);
		
		System.out.println("Enter the starting balance");
		double balance = in.nextDouble();
		
		Account newAccount = new Account(uname, acctNum, balance);
		udao.addUser3(newAccount);
		Logging.logger.info("New bank account opened for user: " + uname);
		
		
	}
}
