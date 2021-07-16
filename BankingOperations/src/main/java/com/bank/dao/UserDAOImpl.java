package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.logging.Logging;
import com.bank.model.Account;
import com.bank.model.User;
import com.bank.util.DAOUtil;

public class UserDAOImpl implements UserDAO {

	Connection connection = null;
	PreparedStatement stmt = null;

	public boolean addUser(User user) {
		// This adds a new user to the user table

		try {
			connection = DAOUtil.getConnection();
			String sql = "INSERT INTO com_bank_users VALUES (?,?,?,?,?)";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, user.getfName());
			stmt.setString(2, user.getlName());
			stmt.setString(3, user.getuName());
			stmt.setString(4, user.getEmail());
			stmt.setInt(5, user.getExec());

			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
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
			String sql = "INSERT INTO com_bank_key VALUES (?,?)";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, user.getuName());
			stmt.setString(2, user.getPassword());

			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
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
		// not done

		try {
			connection = DAOUtil.getConnection();
			String sql = "DELETE com.bank.users, com_bank_bank, com_bank_key FROM com.bank.users "
					+ "INNER JOIN com_bank_bank ON com_bank_bank.u_name = com_bank_users.u_name "
					+ "INNER JOIN com_bank_key ON com_bank_key.u_name = com.bank.users.u_name " + "WHERE u_name = ?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, uName);

		} catch (SQLException e) {
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

	public double checkBalance(String acctNum) {
		//Find the balance of a specific account
		try {
			connection = DAOUtil.getConnection();
			String sql = "SELECT balance FROM com_bank_bank WHERE acctnum=?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, acctNum);

			ResultSet rs = stmt.executeQuery();
//			List<Account> acct = new ArrayList<>();
			Account add = new Account();
			if (stmt.executeUpdate() != 1)
				Logging.logger.error(acctNum + "has multiple entries in the database");
			while (rs.next()) {
//				add = new Account();
				add.setAcctNum(rs.getString(2));
				add.setBalance(rs.getDouble(3));
//				acct.add(add);
			}
			return add.getBalance();
			
		} catch (SQLException e) {
			e.printStackTrace();

		}
		return 0.0;
	}

	public boolean addBalance(double bal, String acct) {
		
		try {
			connection = DAOUtil.getConnection();
			String sql = "UPDATE com_bank_bank SET balance=? WHERE acctnum=?";
			stmt = connection.prepareStatement(sql);

			stmt.setDouble(1, bal);
			stmt.setString(2, acct);

			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			e.printStackTrace();
		}
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

	public List<Account> viewAcct(User user) {

		List<Account> acct = new ArrayList<>();
		try {
			connection = DAOUtil.getConnection();
			String sql = "SELECT * FROM com_bank_bank WHERE uname=?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, user.getuName());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Account add = new Account();
				add.setAcctNum(rs.getString(2));
				add.setBalance(rs.getDouble(3));
				acct.add(add);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return acct;
	}

	public User getUser(String uname) {
		// TODO Auto-generated method stub

		User user = new User();

		try {
			connection = DAOUtil.getConnection();
			String sql = "SELECT * FROM com_bank_users FULL JOIN com_bank_key ON com_bank_users.uname=com_bank_key.uName WHERE com_bank_users.uname=?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, uname);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				user.setfName(rs.getString(1));
				user.setlName(rs.getString(2));
				user.setuName(rs.getString(3));
				user.setEmail(rs.getString(4));
				user.setExec(rs.getInt(5));
				user.setPassword(rs.getString(7));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean checkUser(String uName) {
		try {
			connection = DAOUtil.getConnection();
			String sql = "SELECT uname FROM com_bank_users WHERE uname=?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, uName);

			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return false;
	}
	
	public boolean checkEmail(String uName) {
		try {
			connection = DAOUtil.getConnection();
			String sql = "SELECT email FROM com_bank_users WHERE email=?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, uName);

			if (stmt.executeUpdate() != 0)
				return true;
			else
				return false;
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return false;
	}

}
