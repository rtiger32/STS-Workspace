package ers.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/http");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"/success.jsp\" onSubmit=\"return validateUserName(this.username.value) \">");
		out.println("username: <input type=\"text\" name=\"username\">");
		out.println("<input type=\"submit\" value=\"Submit\">");
		out.println("</form>");
		out.println("<script language=\"JavaScript\">");
		RequestDispatcher rd = request.getRequestDispatcher("/resources/js/validate.js");
		rd.include(request, response);
		out.println("</script>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

}
