package com.bank.model;

import java.util.Random;

public class User {

	private String fName;
	private String lName;
	private String uName;
	private String password;
	private String email;
	private int exec;
	
	public User() {
		super();
	}
	
	public User(String fName, String lName, String password, String email) {
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.uName = fName.charAt(0) + lName + (new Random().nextInt(9000)+1000);
		this.exec = 0;
		this.setEmail(email);
	}
	
	

	public User(String uname, String password) {
		this.fName = null;
		this.lName = null;
		this.password = password;
		this.uName = uname;
		this.exec = 0;
		this.setEmail(null);
	}
	
	public User(String fName, String lName, String password, String uname, int exec, String email) {
		this.fName = fName;
		this.lName = lName;
		this.password = password;
		this.uName = uname;
		this.exec = exec;
		this.setEmail(email);
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

	public int getExec() {
		return exec;
	}

	public void setExec(int exec) {
		this.exec = exec;
	}

	public String getuName() {
		return uName;
	}
	
	
	
	@Override
	public String toString() {
		return "User [fName=" + fName + ", lName=" + lName + ", uName=" + uName + ", password=" + password + ", email="
				+ email + ", exec=" + exec + "]";
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
