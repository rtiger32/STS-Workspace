package com.bank.util;

import java.sql.Connection;

public class Callable {
	private Connection connection = null;
	try {
		connection = DAOUtil.getConnection();
}
