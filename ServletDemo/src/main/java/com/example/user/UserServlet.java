package com.example.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.example.model.User;

public class UserServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		// Set response type to JSON
		res.setContentType("application/json");

		User u1 = new User("test", "pass");
		User u2 = new User("test2", "pass");
		User u3 = new User("test3", "pass");
		User u4 = new User("test4", "pass");

		List<User> uList = new ArrayList<User>();
		uList.add(u1);
		uList.add(u2);
		uList.add(u3);
		uList.add(u4);

		res.getWriter().write(new ObjectMapper().writeValueAsString(uList));

	}
}
