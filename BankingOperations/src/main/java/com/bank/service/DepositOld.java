package com.bank.service;

import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.model.Account;

public class DepositOld {

	private String acctNum;
	private Double balance;
	Scanner in = new Scanner(System.in);
	UserDAOImpl udao = new UserDAOImpl();
	
	public DepositOld() {
	}
	public DepositOld(Account acct) {
		this.setAcctNum(acct.getAcctNum());
		this.setBalance(acct.getBalance());
	}
	
	public void makeDeposit() {
		
		System.out.println("You have $" +balance);
		System.out.println("How much would you like to deposit?");
		double add = in.nextDouble();
		add = (balance + add);
		udao.addBalance(add, acctNum);
	}
	
	public void makeWithdrawl() {
		System.out.println("How much would you like to withdraw?");
	}

	public void makeTransfer() {
		System.out.println("How much would you like to transfer?");
		
	}
	public String getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
}
