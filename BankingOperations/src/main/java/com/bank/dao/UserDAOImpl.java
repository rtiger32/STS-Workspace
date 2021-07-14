package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bank.model.User;
import com.bank.util.DAOUtil;

public class UserDAOImpl implements UserDAO {

	Connection connection = null;
	PreparedStatement stmt = null;
	
	public boolean addUser(User user) {
		// This adds a new user to the user table
		
		try {
			connection = DAOUtil.getConnection();
			String sql = "INSERT INTO com.bank.user VALUES (?,?,?,?,?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1,  user.getfName());
			stmt.setString(2, user.getlName());
			stmt.setString(3,  user.getuName());
			stmt.setString(4,  user.geteMail());
			stmt.setInt(5,  user.getExec());
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}	
		return false;
	}
	
	public boolean addUser2(User user) {
		// This adds to the key table the username and password
		
		try {
			connection = DAOUtil.getConnection();
			String sql = "INSERT INTO com.bank.key VALUES (?,?)";
			stmt = connection.prepareStatement(sql);
			
			stmt.setString(1, user.getuName());
			stmt.setString(2, user.getPassword());
			
			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
				
			}
		}	
		return false;
	}
	

	public boolean removeUserByUsername(String uName) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addBalance(float acctBal) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean resetPass() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setExec(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean viewAcct(User user) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
