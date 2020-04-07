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

@WebServlet("/SubscribeController")
public class SubscribeController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Model model;

	public SubscribeController() {
		super();
		model = new Model();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("In SubscibeController GET");

		HttpSession hs = request.getSession();
		String username = (String) hs.getAttribute("username");
		String topic_id = request.getParameter("topicid");

		System.out.println("User: " + username + " subscribed to: " + topic_id);

		model.subscribeUser(username, topic_id);

		RequestDispatcher rd = request.getRequestDispatcher("/GetTopics");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("In SubscibeController POST");

		HttpSession hs = request.getSession();
		String username = (String) hs.getAttribute("username");
		String topic_id = request.getParameter("topicid");

		System.out.println("User: " + username + " subscribed to: " + topic_id);

		model.subscribeUser(username, topic_id);

		hs.setAttribute("TopicId", topic_id);
		RequestDispatcher rd = request.getRequestDispatcher("/GetPosts");
		rd.forward(request, response);
	}
}
