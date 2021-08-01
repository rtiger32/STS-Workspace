package ers.model;

import java.util.List;

import ers.dao.UserDAO;

public class Display {
	UserDAO u = new UserDAO();

	public boolean out(List<Users> x) {
		for (int i = 0; i < x.size(); i++) {
			System.out.println("<LI>" + x.get(i) + "</LI>");
		}
		return true;
	}
}
