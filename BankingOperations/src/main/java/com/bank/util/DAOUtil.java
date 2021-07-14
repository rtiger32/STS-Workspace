package com.bank.util;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;

	/**
	 * Class used to retrieve DAO Implementations. Serves as a factory. Also manages a single instance of the database connection.
	 */
	public class DAOUtil {

		private static final String CONNECTION_USERNAME = "postgres";
		private static final String CONNECTION_PASSWORD = "password";
		private static final String URL = "jdbc:postgresql://localhost:5432/PubHub";
		private static Connection connection;
		
		public static synchronized Connection getConnection() throws SQLException {
			if (connection == null) {
				try {
					Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					System.out.println("Could not register driver!");
					e.printStackTrace();
				}
				connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
			}
			
			//If connection was closed then retrieve a new connection
			if (connection.isClosed()){
				System.out.println("Opening new connection...");
				connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
			}
			return connection;
		}
		
	//	public static BookDAO getBookDAO() {
	//		return new BookDAOImpl();
	//	}

	

}
