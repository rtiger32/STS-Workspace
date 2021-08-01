import org.junit.Test;

import ers.dao.RequestDAO;
import ers.enums.ReimbStatusEnum;
import ers.enums.UserRoleEnum;
import ers.model.Reimb;
import ers.model.UserRole;
import ers.model.Users;
import ers.service.Request;

public class ReimbursementTest {
	RequestDAO rdao =  new RequestDAO();
	@Test
	public void submitRequestTest() {
		UserRole urole = new UserRole();
		urole.setRole(UserRoleEnum.EMPLOYEE);
		Users user = new Users("test", "employee", "employee", "password", "emp@mail.com", urole);
		Reimb rb = new Reimb(110.00, "test case");
		Request r = new Request();
		System.out.println("Testing rdao insert");
		r.submitRequest(user, rb);
	}
	
	public void resolveRequestTest() {
		UserRole urole = new UserRole();
		
 		urole.setRole(UserRoleEnum.EMPLOYEE);
		Users user = new Users("test", "employee", "employee", "password", "emp@mail.com", urole);
		Reimb rb =  rdao.select(1);
		Request r = new Request();
		System.out.println("Testing rdao insert");
		r.resolveRequest(ReimbStatusEnum.DENIED, user,rb);
	}
	
	public void retrieveAllTest() {
		rdao.selectAll();
	}
	
}
