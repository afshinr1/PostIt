package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Model model;

	public Logout() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In Logout.java doGet");

			HttpSession session = request.getSession();
			session.setAttribute("username", null);
			session.setAttribute("email", null);
			response.sendRedirect(request.getContextPath() + "/GetTopics");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In Logout.java doPost");

		HttpSession session = request.getSession();
		session.setAttribute("username", null);
		session.setAttribute("email", null);
		response.sendRedirect(request.getContextPath() + "/GetTopics");
		}
	}

