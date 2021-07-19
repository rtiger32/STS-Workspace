package com.bank.model;

public class Account extends User{

	private String acctNum;
	private double balance;
	
	public Account() {
		
	}
	
	public Account(String uName, String acctNum, double balance) {
		super();
		setuName(uName);
		this.acctNum = acctNum;
		this.balance = balance;
	}
	
	public Account(String fName, String lName, String password, String uname, 
			int exec, String email,	 String uName, String acctNum, double balance) {
		setfName( fName);
		setlName(lName);
		setPassword(password);
		setuName(uName);
		setExec(exec);
		setEmail(email);
		this.acctNum = acctNum;
		this.balance = balance;
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
		return "Account [uName=" + getuName() + ", acctNum=" + acctNum + ", balance=" + balance + "]";
	}
	





}
