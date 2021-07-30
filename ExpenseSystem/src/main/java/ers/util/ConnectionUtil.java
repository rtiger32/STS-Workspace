package ers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class used to retrieve DAO Implementations. Serves as a factory. Also manages
 * a single instance of the database connection.
 */
public class ConnectionUtil {

	private static final String CONNECTION_USERNAME = "p1";
	private static final String CONNECTION_PASSWORD = "password";
	private static final String URL = "jdbc:postgresql://revaturejava0621.cmtwcjnphlh8.us-east-1.rds.amazonaws.com:5432/ersdb";
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

		// If connection was closed then retrieve a new connection
		if (connection.isClosed()) {
			System.out.println("Opening new connection...");
			connection = DriverManager.getConnection(URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
		}
		return connection;
	}
}