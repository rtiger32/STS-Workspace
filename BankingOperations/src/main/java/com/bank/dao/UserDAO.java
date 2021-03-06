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

	public boolean addBalance(double bal, String acct);

	public boolean resetPass(String uname, String password);

	public boolean setExec(User user, int ex);

	public List<?> viewAcct(User user);

}
