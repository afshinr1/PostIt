package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Model;

@WebServlet("/GetTopics")
public class GetTopics extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Model model;

	public GetTopics() {
		super();
		model = new Model();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get topics");

		String topics = model.getTopics();
		request.setAttribute("topics", topics);
		request.getRequestDispatcher("topicspage.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Get topics");

		String topics = model.getTopics();
		request.setAttribute("topics", topics);
		request.getRequestDispatcher("topicspage.jsp").forward(request, response);
	}
}
