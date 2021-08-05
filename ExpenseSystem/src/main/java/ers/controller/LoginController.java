package ers.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import ers.enums.UserRoleEnum;
import ers.model.UserRole;
import ers.model.Users;

public class LoginController {

	public static void login(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// TODO Auto-generated method stub

		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();

		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}

		String data = buffer.toString();
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);

		String username = parsedObj.get("username").asText();
		System.out.println(username);
		String password = parsedObj.get("password").asText();
		System.out.println(password);

		Validate v = new Validate();
		Users u = v.checkUser(username, password);
		if (u == null) {
			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Username or Passsword incorrect");
		} else {
			res.setStatus(HttpServletResponse.SC_OK);

			HttpSession session = req.getSession();
			session.setAttribute("user", u);

			res.getWriter().write(new ObjectMapper().writeValueAsString(u));
		}
	}

	public static void logadmin(HttpServletRequest req, HttpServletResponse res)
			throws JsonProcessingException, IOException {
		// TODO Auto-generated method stub

		StringBuilder buffer = new StringBuilder();
		BufferedReader reader = req.getReader();

		String line;
		while ((line = reader.readLine()) != null) {
			buffer.append(line);
			buffer.append(System.lineSeparator());
		}

		String data = buffer.toString();
		System.out.println(data);
		ObjectMapper mapper = new ObjectMapper();
		JsonNode parsedObj = mapper.readTree(data);

		String username = parsedObj.get("username").asText();
		System.out.println(username);
		String password = parsedObj.get("password").asText();
		System.out.println(password);

		Validate v = new Validate();
		Users u = v.checkUser(username, password);
		UserRole role = new UserRole(UserRoleEnum.MANAGER);
		if (u.getRole() == role) {
			res.setStatus(HttpServletResponse.SC_OK);
			HttpSession session = req.getSession();
			session.setAttribute("user", u);

			res.getWriter().write(new ObjectMapper().writeValueAsString(u));
		} else {

			res.setStatus(HttpServletResponse.SC_FORBIDDEN);
			res.getWriter().println("Username or Passsword incorrect");

		}
	}
}
