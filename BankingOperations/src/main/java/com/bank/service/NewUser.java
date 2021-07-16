package com.bank.service;

import java.util.Random;
import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.model.User;

public class NewUser {

	public NewUser() {
		
	}

	public void init() {
		
			UserDAOImpl udao = new UserDAOImpl();
			Scanner in = new Scanner(System.in);
			System.out.println("\nThank you for choosing our bank.\nWhat is your first name?");
			String fName = in.nextLine().toLowerCase();
			System.out.println("\nWhat is your Last name?");
			String lName = in.nextLine().toLowerCase();
			System.out.println("\nEnter your email address.");
			String email = in.nextLine().toLowerCase(); // check to see if username exists
			String uName = "";
			String clName = "";
			if (lName.length() < 5)
				clName = lName;
			else
				clName = lName.substring(0, 4);
			System.out.println(clName);
			uName = fName.charAt(0) + clName + (new Random().nextInt(9000) + 1000);
			// System.out.println(udao.checkUser(uName));

			System.out.println("Create a Password (Case Sensitive):");
			String password = in.nextLine();
			System.out.println("Thank you.\nYour username is: " + uName + "\n please use this to login");
			User u = new User(fName, lName, password, uName, 0, email);
			udao.addUser(u);
			udao.addUser2(u);
			//System.out.println(u);
		}
}
