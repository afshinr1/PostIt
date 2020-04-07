package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Model model;

	public ValidateUser() {
		super();
		model = new Model();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In validate user GET");

		String uName = request.getParameter("uname");
		String uPass = request.getParameter("upass");

		if (model.validateUser(uName, uPass)) {
			String email = model.getEmail(uName);
			HttpSession session = request.getSession();
			session.setAttribute("username", uName);
			session.setAttribute("email", email);
			response.sendRedirect(request.getContextPath() + "/GetTopics");

		}

		else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In validate user");
		String uName = request.getParameter("uname1");
		String uPass = request.getParameter("upass");
		System.out.println("AJFASJF" + uName + " " + uPass);
		if (model.validateUser(uName, uPass)) {
			String email = model.getEmail(uName);
			HttpSession session = request.getSession();
			session.setAttribute("username", uName);
			session.setAttribute("email", email);

			response.sendRedirect(request.getContextPath() + "/GetTopics");

		}

		else {
			RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
			rd.forward(request, response);
		}
	}
}
