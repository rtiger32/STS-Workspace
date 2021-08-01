package ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ers.dao.UserDAO;
import ers.enums.UserRoleEnum;
import ers.model.UserRole;
import ers.model.Users;

public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.getRequestDispatcher("link.html").include(request, response);

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		UserDAO udao = new UserDAO();
		Users u = udao.selectByName(name);
		if (u.getPassword().equals(password)) {
			out.print("Welcome, " + u.getFname() + " " + u.getLname());
			HttpSession session = request.getSession();
			session.setAttribute("name", name);
			UserRole ur = u.getRole();
			if (ur.getRole() == UserRoleEnum.MANAGER) {
				request.getRequestDispatcher("manager.html").include(request, response);
			} else {
				request.getRequestDispatcher("employee.html").include(request, response);
			}

		} else {
			out.print("Sorry, username or password error!");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		out.close();
	}
}