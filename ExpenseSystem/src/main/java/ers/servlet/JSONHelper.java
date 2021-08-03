package ers.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ers.controller.EmployeeController;
import ers.controller.LoginController;
import ers.controller.ManagerController;

/**
 * Servlet implementation class JSONHelper
 */
public class JSONHelper extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static void process(HttpServletRequest req, HttpServletResponse res) throws IOException {
		switch (req.getRequestURI()) {
		// create one for each web page
		case "/ExpenseSystem/api/index":
			LoginController.login(req, res);
		case "/ExpenseSystem/api/employee":
			EmployeeController.newRequest(req, res);
		case "/ExpenseSystem/api/manager":
			ManagerController.home(req, res);
		}
	}
}
