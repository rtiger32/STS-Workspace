package ers.service;

import ers.dao.RequestDAO;
import ers.dao.UserDAO;
import ers.enums.UserRoleEnum;
import ers.model.Reimb;
import ers.model.UserRole;
import ers.model.Users;

public class TestDriver {

	public static void main(String[] args) {
		UserDAO udao = new UserDAO();
		UserRole urole = new UserRole();
		urole.setRole(UserRoleEnum.EMPLOYEE);
		Users user = new Users("test", "user", "tuser0000", "password", "test@mail.com", urole);
		System.out.println(user);
		System.out.println("Testing udao.insert");
		udao.insert(user);
		RequestDAO rdao = new RequestDAO();
		Reimb rb = new Reimb(100.00, false, false, "test case");
		System.out.println("Testing rdao insert");
		rdao.insert(rb);
	}
}
