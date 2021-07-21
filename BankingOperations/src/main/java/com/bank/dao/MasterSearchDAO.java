package com.bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bank.model.Account;
import com.bank.model.User;
import com.bank.util.DAOUtil;

public class MasterSearchDAO {
	private Connection connection = null;
	private PreparedStatement stmt = null;

	public List<Account> SUbyname(String fname, String lname) {

		List<Account> acct = new ArrayList<>();

		try {
			connection = DAOUtil.getConnection();
			String sql = "SELECT * FROM com_bank_users FULL JOIN com_bank_bank on com_bank_bank.uname = com_bank_users.uname WHERE fname LIKE ? AND lname LIKE ?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, fname);
			stmt.setString(2, lname);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Account add = new Account();
				add.setfName(rs.getString(1));
				add.setlName(rs.getString(2));
				add.setuName(rs.getString(3));
				add.setEmail(rs.getString(4));
				add.setAcctNum(rs.getString(7));
				add.setBalance(rs.getDouble(8));

				acct.add(add);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return acct;
	}

	public List<Account> SUbyusername(String uname) {

		List<Account> acct = new ArrayList<>();

		try {
			connection = DAOUtil.getConnection();
			String sql = "SELECT * FROM com_bank_users FULL JOIN com_bank_bank on com_bank_bank.uname = com_bank_users.uname WHERE com_bank_users.uname LIKE ?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, uname);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Account add = new Account();
				add.setfName(rs.getString(1));
				add.setlName(rs.getString(2));
				add.setuName(rs.getString(3));
				add.setEmail(rs.getString(4));
				add.setAcctNum(rs.getString(7));
				add.setBalance(rs.getDouble(8));

				acct.add(add);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return acct;
	}

	public List<Account> SUbyacctnum(String acctnum) {

		List<Account> acct = new ArrayList<>();

		try {
			connection = DAOUtil.getConnection();
			String sql = "SELECT * FROM com_bank_users FULL JOIN com_bank_bank on com_bank_bank.uname = com_bank_users.uname WHERE acctnum like ?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, acctnum);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Account add = new Account();
				add.setfName(rs.getString(1));
				add.setlName(rs.getString(2));
				add.setuName(rs.getString(3));
				add.setEmail(rs.getString(4));
				add.setAcctNum(rs.getString(7));
				add.setBalance(rs.getDouble(8));

				acct.add(add);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return acct;
	}

	public List<Account> SUbyemail(String email) {

		List<Account> acct = new ArrayList<>();

		try {
			connection = DAOUtil.getConnection();
			String sql = "SELECT * FROM com_bank_users FULL JOIN com_bank_bank on com_bank_bank.uname = com_bank_users.uname WHERE email LIKE ?";
			stmt = connection.prepareStatement(sql);

			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Account add = new Account();
				add.setfName(rs.getString(1));
				add.setlName(rs.getString(2));
				add.setuName(rs.getString(3));
				add.setEmail(rs.getString(4));
				add.setAcctNum(rs.getString(7));
				add.setBalance(rs.getDouble(8));

				acct.add(add);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return acct;
	}
}