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
		Users u = (Users) session.getAttribute("user");
		if(req.getMethod().equals("GET")) {
		//	List<Reimb> in = view.employeeAll(null)
			res.getWriter().write(new ObjectMapper().writeValueAsString(view.employeeAll(u.getUname())));
		}
	else {
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
		
		double amount = Integer.parseInt(parsedObj.get("amount").asText());
		String request = parsedObj.get("request").asText();
		
		Reimb entry = new Reimb(amount, request);
		rdao.insert(entry);
		
		//pServ.addPost(userId, wallId, content);
		
		ObjectNode ret = mapper.createObjectNode();
		ret.put("message", "successfully submitted a new reimbursment");
		
		res.getWriter().write(new ObjectMapper().writeValueAsString(ret));
	}
	
}

}

