package ers.controller;

import ers.dao.UserDAO;
import ers.enums.UserRoleEnum;
import ers.model.UserRole;
import ers.model.Users;

public class Validate {

	// take a UN and PW, and convert to user object
	public Users checkUser(String name, String pass) {
		UserDAO udao = new UserDAO();
		Users u = udao.selectByName(name);
		if (u.getPassword().equals(pass)) {
			return u;
		}
		return null;
	}

}
