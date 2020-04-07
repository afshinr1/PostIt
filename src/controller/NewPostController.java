package controller;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

@WebServlet("/NewPostController")
public class NewPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Model model;

	public NewPostController() {
		super();
		model = new Model();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In new post get!");

		RequestDispatcher rd = request.getRequestDispatcher("/GetPosts");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In new post post!");
		String postContent = request.getParameter("content");
		String title = request.getParameter("title");
		HttpSession session = request.getSession();
		String topicid = (String) session.getAttribute("TopicId");
		// Get topic id
		int topicID = Integer.parseInt(topicid);
		String username = (String) session.getAttribute("username");
		int votes = 0;
		UUID uuid = UUID.randomUUID();
		String randomUUIDString = uuid.toString();

		model.createNewPost(postContent, username, topicID, randomUUIDString, votes, title);

		RequestDispatcher rd = request.getRequestDispatcher("/GetPosts");
		rd.forward(request, response);
	}
}
