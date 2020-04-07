package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

@WebServlet("/GetPosts")
public class GetPosts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Model model;

	public GetPosts() {
		super();
		model = new Model();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In getposts");

		// Get topic ID and get posts related to that id
		HttpSession session = request.getSession();
		String topicId = (String) session.getAttribute("TopicId");
		System.out.println("TOPIC ID IN GET POSTS:" + topicId);

		String info;
		info = model.getPosts(topicId);
		String image = model.getImage();
		request.setAttribute("image", image);
		System.out.println(info);
		request.setAttribute("allPosts", info);
		request.getRequestDispatcher("home.jsp").forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("In getposts");

		// Get topic ID and get posts related to that id
		HttpSession session = request.getSession();
		String topicId = (String) session.getAttribute("TopicId");
		System.out.println("TOPIC ID IN GET POSTS:" + topicId);

		String info;
		info = model.getPosts(topicId);
		String image = model.getImage();
		request.setAttribute("image", image);
		System.out.println(info);
		request.setAttribute("allPosts", info);
		request.getRequestDispatcher("home.jsp").forward(request, response);

	}
}
