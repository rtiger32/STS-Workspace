package com.bank.dao;

import com.bank.model.User;

public interface UserDAO {
	
	//add user
	//remove user
	//add balance
	//remove balance
	//reset password
	
	public boolean addUser(User user);
	public boolean removeUserByUsername(String uName);
	public boolean addBalance(float acctBal);
	public boolean resetPass();
	
	public boolean setExec(User user);
	public boolean viewAcct(User user);
	
}
