package com.bank.service;

import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.logging.Logging;
import com.bank.model.Account;

public class Deposit {

	private Account acct;
	private Scanner in = new Scanner(System.in);
	private UserDAOImpl udao = new UserDAOImpl();

	public Deposit() {
	}

	public Deposit(Account acct) {
		this.acct = acct;
	}

	public void showBalance() {
		System.out.println("Account " + acct.getAcctNum() + " has $" + acct.getBalance());
	}

	public void makeDeposit() {
		System.out.println("How much would you like to deposit?");
		double add;
		try {
			add = in.nextDouble();
		} catch (Exception e) {
			add = 0;
		}
		if (add < 0) {
			System.out.println("You cannot deposit a negative number");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return;
		}
		makeDeposit(add, acct.getuName());
	}

	public void makeDeposit(double add, String uname) {
		double add2 = (acct.getBalance() + add);
		udao.addBalance(add2, acct.getAcctNum());
		Logging.logger.info(uname + " has deposited $" + add + " into account " + acct.getAcctNum());
		Logging.logger.info(". The new balance for " + acct.getAcctNum() + " is: $" + acct.getBalance());
		System.out.println("$" + add + " has been deposited into " + acct.getAcctNum());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void makeWithdrawl() {
		if (acct.getBalance() < 0) {
			System.out.println("You have no money to withdraw");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		} else {
			System.out.println("How much would you like to withdraw?");
			double add;
			try {
				add = in.nextDouble();
			} catch (Exception e) {
				add = 0;
			}
			if (add < 0) {
				System.out.println("You cannot withdraw a negative number");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			makeWithdrawl(add);
		}
	}

	public void makeWithdrawl(double add) {
		double fine = 0;
		double add2 = (acct.getBalance() - add);
		if (add2 < 0)
			if (add * 0.1 > 25)
				fine = add2 * 0.1;
			else
				fine = 25;
		add2 = add2 - fine;

		udao.addBalance(add2, acct.getAcctNum());
		Logging.logger.info(acct.getuName() + " has withdrawn $" + add + " from account " + acct.getAcctNum());
		System.out.println("$" + add + " has been withdrawn from " + acct.getAcctNum());
		if (fine > 0) {
			System.out.println("Your account has been overdrawn. " + "\nYou have been charged a fee of $" + fine);
			Logging.logger.warn(acct.getAcctNum() + " has been overdrawn");
		}
		Logging.logger.info("The new balance is: $" + acct.getBalance());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void makeTransfer(Deposit trans) {
		if (acct.getBalance() < 0) {
			System.out.println("You have no money to transfer");
		} else {
			System.out.println("How much would you like to transfer?");
			double add;
			try {
				add = in.nextDouble();
			} catch (Exception e) {
				add = 0;
			}
			if (add < 0) {
				System.out.println("You cannot transfer a negative number");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				return;
			}
			makeWithdrawl(add);
			trans.makeDeposit(add, acct.getuName());
		}
	}
}
