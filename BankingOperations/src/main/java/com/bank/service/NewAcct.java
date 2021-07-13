package com.bank.service;

public class NewAcct {

	private String uName;
	private long acctNum;
	public NewAcct () {
		
	}
	
	public NewAcct (String uName) {
		this.uName = uName;
		
		//SELECT COUNT(*)
		//FROM com.bank.user
		
		acctNum = 1000000000;
		// + the result of the above query
		
		
	}
	
}
