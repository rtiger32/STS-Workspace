package ers.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import ers.dao.RequestDAO;
import ers.dao.UserDAO;
import ers.model.Reimb;
import ers.model.Users;
import ers.service.Request;
import ers.service.View;



public class EmployeeController {

	private static UserDAO udao = new UserDAO();
	private static RequestDAO rdao = new RequestDAO();
	private static View view = new View();
	private static Request rq = new Request();
	
	public static void newRequest(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {
		
		HttpSession session = req.getSession();
		Users user = (Users) session.getAttribute("user");
		
		
		if(req.getMethod().equals("GET")) {
		System.out.println("EmployeeController: " + user);
			System.out.println(view.employeeAll(user.getUname()));
			res.getWriter().write(new ObjectMapper().writeValueAsString(view.employeeAll(user.getUname())));			
		}
	else {
		System.out.println("EmployeeController: " + user);
		//To read in stringified JSON data is a bit more complicated,
		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		
		String line;
		while((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}
		String data = buffer.toString();
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);
		
		float amount = Float.parseFloat(parsedObj.get("amount").asText());
		String type = parsedObj.get("type").asText();
		String description = parsedObj.get("description").asText();
		System.out.println(amount + " " + type + " " + description);
		Reimb reimb = new Reimb(amount, description);
		
		try {
		rq.submitRequest(user, reimb, type);
		res.setStatus(HttpServletResponse.SC_OK);
		} catch (Exception e) {
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
		return;
		}
		res.getWriter().println("successfully submitted a new reimbursment");		
	}
	
}

}

