package ers.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;

import ers.controller.LoginController;

public class ServletJSONHelper {

	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException {

		switch (req.getRequestURI()) {
		case "/ExpenseSystem/api/login":
			LoginController.login(req, res);
			break;
			
		}
	}

}
