package com.bank.service;

import java.util.List;
import java.util.Scanner;

import com.bank.dao.MasterSearchDAO;
import com.bank.model.Account;

public class MasterSearch {

	private Scanner in = new Scanner(System.in);
	private MasterSearchDAO mdao = new MasterSearchDAO();
	private int search;
	private List<Account> result;

	private void result(List<Account> result) {
		Account u = new Account();
		if (result.size() == 0) {
			System.out.println("No match found");
		} else {
			for (int i = 0; i < result.size(); i++) {
				u = result.get(i);
				System.out.println("\n\nFirst Name: " + u.getfName() + " Last Name: " + u.getlName() + "\nUsername: "
						+ u.getuName() + "  Email: " + u.getEmail() + " Account number: " + u.getAcctNum()
						+ "  Balance: " + u.getBalance());
			}
			System.out.println("Press any key");
			in.nextLine();
		}
	}

	public void search() {

		for (int i = 0; i != 60; i++) {
			System.out.println();
		}

		System.out.println(
				"MASTER SEARCH\n\nHow would you like to search?\n\n1) Search by name\n2) Search by username\n3) Search by email address\n4) Search by account number\n5) End search");
		try {
			search = Integer.parseInt(in.nextLine());
		} catch (Exception e) {

		}

		switch (search) {
		case 1:
			System.out.println("Enter the first name:");
			String fname = in.nextLine();
			System.out.println("Enter the last name:");
			String lname = in.nextLine();
		 result = mdao.SUbyname(fname, lname);
			result(result);
		break;
		case 2:
			System.out.println("Enter the username:");
			String uname = in.nextLine();
			result = mdao.SUbyusername(uname);
			result(result);
			break;
		case 3:
			System.out.println("Enter the account number:");
			String acctnum = in.nextLine();
			 result = mdao.SUbyacctnum(acctnum);
			result(result);
			break;
		case 4:
			System.out.println("Enter the Email address:");
			String email = in.nextLine();
			result = mdao.SUbyemail(email);
			result(result);
			break;
		case 5:
			return;
		default:
			return;

		}

	}
}
