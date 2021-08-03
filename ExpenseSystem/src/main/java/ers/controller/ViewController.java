package ers.controller;

import javax.servlet.http.HttpServletRequest;

public class ViewController {

	public static String fetchIndex(HttpServletRequest req) {
		System.out.println(req.getContentType());
		System.out.println("Return index.html");
		return "resources/html/index.html";
	}

	public static String fetchEmployee(HttpServletRequest req) {
		System.out.println(req.getContentType());
		System.out.println("Return employee.html");
		return "resources/html/employee.html";
	}

	public static String fetchManager(HttpServletRequest req) {
		System.out.println(req.getContentType());
		System.out.println("Return manager.html");
		return "resources/html/manager.html";
	}

}
