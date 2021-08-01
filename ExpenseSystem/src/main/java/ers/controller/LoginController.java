package ers.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ers.dao.UserDAO;
import ers.model.Users;
import ers.service.UserService;

public class LoginController {

	private static UserDAO udao = new UserDAO();
	private static UserService userv = new UserService();

	public static void login(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {

		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();
		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}

		String data = buffer.toString();
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);

		String username = parsedObj.get("username").asText();
		String password = parsedObj.get("password").asText();

		try {
			Users u = userv.signIn(username, password);
			req.getSession().setAttribute("role", udao.selectRole(username));
			res.setStatus(HttpServletResponse.SC_OK);
			res.getWriter().write(new ObjectMapper().writeValueAsString(u));
		} catch (Exception e) {
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Username or Password Incorrect");
		}
	}
}
