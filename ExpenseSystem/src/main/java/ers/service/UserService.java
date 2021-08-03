package ers.service;

import ers.dao.UserDAO;
import ers.log.Logging;
import ers.model.Users;

public class UserService {

	private UserDAO udao;

	public UserService() {
		// TODO Auto-generated constructor stub
	}

	public Users signIn(String username, String password) {
		
			Users u = udao.selectByName(username);
			if (u.getUname() == null) {
				Logging.logger.warn("User tried logging in that does not exist");
				// user does not exist
			}
			if (!u.getPassword().equals(password)) {
				Logging.logger.warn("User tried to login with invalid credentials");
				return null;
			} else {
				Logging.logger.info("User was logged in");
				return u;
			}
	}
}
