package com.bank.service;

import com.bank.logging.Logging;

public class Main {

	public static void main(String[] args) {

		Logging.logger.info("Program has started");
		Welcome wel = new Welcome();
		while (true) {		
			wel.init();
		}
	}
}