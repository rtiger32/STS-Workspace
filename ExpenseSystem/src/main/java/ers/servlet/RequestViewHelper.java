package ers.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import ers.controller.ViewController;

public class RequestViewHelper {
//Servlet
	public static String process(HttpServletRequest req) throws ServletException, IOException {

		switch (req.getRequestURI()) {
		case "/ExpenseSystem/index":
			return ViewController.fetchLoginPage(req);
		case "/ExpenseSystem/employee":
			return ViewController.fetchEmployeePage(req);
		case "/ExpenseSystem/manager":
			return ViewController.fetchManagerPage(req);
		case"/ExpenseSystem/sitemap":
			return "resources/html/sitemap.html";
		}
		return "resources/html/index.html";
	}
}
