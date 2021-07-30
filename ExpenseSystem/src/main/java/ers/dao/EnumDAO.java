package ers.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ers.util.ConnectionUtil;

public class EnumDAO {

	private Connection connection = null;
	private PreparedStatement stmt = null;

	public boolean enumInit() {
		// Populate the Enum SQL tables if the tables are empty
		try {
			connection = ConnectionUtil.getConnection();
			String sql = "SELECT COUNT(user_role) FROM ers_user_roles";
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			if (rs.getInt(1) == 0) {
				sql = "INSERT INTO ers_user_roles(user_role) VALUES ('employee', 'manager')";
				stmt = connection.prepareStatement(sql);
				stmt.execute();
			}
			sql = "SELECT COUNT(reinb_status) FROM ers_reinbursement_status";
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.getInt(1) == 0) {
				sql = "INSERT INTO ers_reinbursement_status(reinb_status) VALUES ('pending', 'approved', 'denied')";
				stmt = connection.prepareStatement(sql);
				stmt.execute();
			}
			sql = "SELECT COUNT(reinb_type) FROM ers_reinbursement_type";
			stmt = connection.prepareStatement(sql);
			rs = stmt.executeQuery();

			if (rs.getInt(1) == 0) {
				sql = "INSERT INTO ers_reinbursement_type(reinb_type) VALUES ('lodging', 'travel', 'food','other')";
				stmt = connection.prepareStatement(sql);
				stmt.execute();
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
		return false;
	}
}
