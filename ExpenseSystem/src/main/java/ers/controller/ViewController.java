package ers.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

public class ViewController {
	//JSON
	
	public static String fetchLoginPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view index.html");
		return "resources/html/index.html";
	}
	
	public static String fetchEmployeePage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view Employee.html");
		return "resources/html/employee.html";
		
	}
	
	public static String fetchManagerPage(HttpServletRequest req) throws ServletException, IOException {
		System.out.println(req.getContentType());
		System.out.println("This should return the view Manager.html");
		return "resources/html/manager.html";
	}
	
}