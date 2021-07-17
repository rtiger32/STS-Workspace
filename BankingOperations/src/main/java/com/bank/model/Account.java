package com.bank.model;

public class Account {

	private String uName;
	private String acctNum;
	private double balance;
	
	
	public Account() {
		
	}
	
	public Account(String uName, String acctNum, double balance) {
		super();
		this.uName = uName;
		this.acctNum = acctNum;
		this.balance = balance;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getAcctNum() {
		return acctNum;
	}

	public void setAcctNum(String acctNum) {
		this.acctNum = acctNum;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [uName=" + uName + ", acctNum=" + acctNum + ", balance=" + balance + "]";
	}
	





}
