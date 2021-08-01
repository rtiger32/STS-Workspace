package ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ers.dao.RequestDAO;
import ers.dao.UserDAO;
import ers.model.Display;
import ers.model.Users;

public class FormServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
		RequestDAO rdao = new RequestDAO();
		UserDAO udao = new UserDAO();
		List<Users> ulist = udao.selectAll();
		Display d = new Display();
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		String docType = "<!DOCTYPE HTML>";
		String title = "title here";
		out.println(docType + "<HTML>\n<HEAD><TITLE>" + title + "</TITLE></HEAD>\n"
				+ "<BODY>\n <UL>\n");
		out.println(d.out(ulist));
	
		out.println("</UL></BODY></HTML>");
	}
	
}
