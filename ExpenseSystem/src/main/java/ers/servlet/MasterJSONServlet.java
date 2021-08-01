package ers.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterJSONServlet extends HttpServlet{

	
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		ServletJSONHelper.process(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		ServletJSONHelper.process(req, res);
	
	}
	
}
