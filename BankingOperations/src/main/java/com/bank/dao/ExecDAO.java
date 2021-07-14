package com.bank.dao;

import com.bank.model.User;

public interface ExecDAO {

	//add employee
	//remove employee
	//view the logs
	//view account by ID
	
	public boolean setExec(User user);
	public boolean viewAcct(User user);
}
