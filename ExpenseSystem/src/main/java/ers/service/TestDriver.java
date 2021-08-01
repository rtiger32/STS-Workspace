package ers.service;

import ers.dao.RequestDAO;
import ers.dao.UserDAO;
import ers.enums.ReimbStatusEnum;
import ers.enums.UserRoleEnum;
import ers.model.Reimb;
import ers.model.UserRole;
import ers.model.Users;

public class TestDriver {
//succeeded 073021

	private static final ReimbStatusEnum APPROVED = null;

	public static void main(String[] args) {
		UserDAO udao = new UserDAO();
		UserRole urolee = new UserRole();
		urolee.setRole(UserRoleEnum.EMPLOYEE);
		UserRole urolem = new UserRole();
		urolem.setRole(UserRoleEnum.MANAGER);
		
		Users userE = new Users("test", "employee2", "employee2", "password", "emp3@mail.com", urolee);
		Users userM = new Users("test", "manager", "manager", "password", "man@mail.com", urolem);
//		System.out.println(user);
		System.out.println("Testing udao.insert");
//		udao.insert(userE);
//		udao.insert(userM);
//		RequestDAO rdao = new RequestDAO();
		Reimb rb = new Reimb(450.00, "test case");
		Request r = new Request();
//		System.out.println("Testing rdao insert");
		r.submitRequest(userE, rb);
//		r.resolveRequest(ReimbStatusEnum.DENIED,userM, rdao.select(3));
	}
}
