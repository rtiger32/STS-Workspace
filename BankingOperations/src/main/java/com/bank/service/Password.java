package com.bank.service;

import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.logging.Logging;
import com.bank.model.User;

public class Password {

	Scanner in = new Scanner(System.in);
	UserDAOImpl udao = new UserDAOImpl();

	public boolean change(String user) {
		int count = 0;
		while (count < 3) {
			System.out.println("Please enter your current password");
			User signin = udao.getUser(user);
			if (in.nextLine().equals(signin.getPassword())) {
				System.out.println("Enter your new password");
				String change = in.nextLine();
				System.out.println("Please retype your new password");
				if (change.equals(in.nextLine())) {
					signin.setPassword(change);
					System.out.println("Your password has been changed. \nYou will now be logged out.");
					udao.resetPass(signin.getuName(), change);
					Logging.logger.info(user + " has changed their password");
					return true;
				} else {
					System.out.println("Sorry, Your passwords did not match.");
					count++;
				}
			} else {
				System.out.println("Invalid password, try again");
				count++;
			}
		}
		Logging.logger.warn("An attempt was made to change the password of user " + user);
		return false;
	}
}
