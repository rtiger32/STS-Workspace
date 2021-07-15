package com.bank.dao;

import java.util.List;

import com.bank.model.User;

public interface UserDAO {

	// add user
	// remove user
	// add balance
	// remove balance
	// reset password

	public User getUser(String uname);

	public boolean addUser(User user);

	public boolean removeUserByUsername(String uname);

	public boolean addBalance(float acctBal);

	public boolean resetPass();

	public boolean setExec(User user);

	public List<?> viewAcct(User user);

}
