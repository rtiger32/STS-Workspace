package com.bank.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.bank.dao.UserDAOImpl;
import com.bank.logging.Logging;
import com.bank.model.Account;
import com.bank.model.User;

public class Main {

	public static void main(String[] args) {

		Logging.logger.info("Program has started");
		Welcome wel = new Welcome();
		while (true) {		
			wel.init();
		}
	}
}