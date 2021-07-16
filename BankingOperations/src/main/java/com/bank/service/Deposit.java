package com.bank.service;

import java.util.Scanner;

import com.bank.dao.UserDAOImpl;

public class Deposit {

	private String check; //this is the account number
	Scanner in = new Scanner(System.in);
	UserDAOImpl udao = new UserDAOImpl();
	
	
	public Deposit(String check) {
		this.check = check;
	}

	public void makeDeposit() {
		System.out.println("How much would you like to deposit?");
		
	}
	
	public void makeWithdrawl() {
		System.out.println("How much would you like to withdraw?");
	}

	public void makeTransfer() {
		System.out.println("How much would you like to transfer?");
		
	}
}
