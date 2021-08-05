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

		Users userE = new Users("test", "employee", "employee", "password", "emp@mail.com", urolee);
		Users userE2 = new Users("test", "employee2", "employee2", "password", "emp2@mail.com", urolee);

		Users userM = new Users("test", "manager", "manager", "password", "man@mail.com", urolem);

		RequestDAO rdao = new RequestDAO();
		Reimb rb = new Reimb();
		Request r = new Request();
//		rb = new Reimb(450.00, "Hosted group meeting with investors at Libretores");
//		r.submitRequest(userE, rb, "Food");
//		rb = new Reimb(1450.00, "Round trip travel to Chicago to meet new client");
//		r.submitRequest(userE, rb, "Travel");
//		rb = new Reimb(350.00, "Chicago Hilton for three days");
//		r.submitRequest(userE, rb, "Travel");
//		rb = new Reimb(14450.00, "You owe me this");
//		r.submitRequest(userE2, rb, "Other");
//		rb = new Reimb(15450.00, "Why wont you help me?");
//		r.submitRequest(userE2, rb, "Other");
//		rb = new Reimb(25450.00, "Give me your cash or else!");
//		r.submitRequest(userE2, rb, "Other");

//		r.resolveRequest(ReimbStatusEnum.APPROVED,userM, rdao.select(36));
		r.resolveRequest(ReimbStatusEnum.APPROVED,userM, rdao.select(33));
	}
}
