package com.bank.model;

import java.util.Random;

public class User {

	private String fName;
	private String lName;
	private String uName;
	private String password;
	private boolean exec;
	
	public User() {
		super();
	}
	
	public User(String fName, String lName, String password) {
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.uName = fName.charAt(0) + lName + (new Random().nextInt(9000)+1000);
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isExec() {
		return exec;
	}

	public void setExec(boolean exec) {
		this.exec = exec;
	}

	public String getuName() {
		return uName;
	}
	
	
	
	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", uName=" + uName + ", password=" + password + ", exec="
				+ exec + "]";
	}

}
