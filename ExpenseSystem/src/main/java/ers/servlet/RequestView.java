package ers.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ers.controller.ViewController;

/**
 * Servlet implementation class RequestView
 */
public class RequestView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public static String process(HttpServletRequest req) {
		System.out.println("In request helper with URI: " + req.getRequestURI());

		switch (req.getRequestURI()) {
		// case for each page
		case "/ExpenseSystem/index":
			return ViewController.fetchIndex(req);
		case "/ExpenseSystem/employee":
			return ViewController.fetchEmployee(req);
		case "/expenseSystem/manager":
			return ViewController.fetchManager(req);
		default:	
			return "/ExpenseSystem/index";
		}

	}
}