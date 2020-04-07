package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/TopicController")
public class TopicController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TopicController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String topic_id = request.getParameter("topicid");
		HttpSession session = request.getSession();
		session.setAttribute("TopicId", topic_id);
		System.out.println("TOPIC ID IN TOPICS CONTROLLER : " + topic_id);
		RequestDispatcher rd = request.getRequestDispatcher("/GetPosts");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String topic_id = request.getParameter("topicid");
		HttpSession session = request.getSession();
		session.setAttribute("TopicId", topic_id);
		System.out.println("TOPIC ID IN TOPICS CONTROLLER : " + topic_id);
		RequestDispatcher rd = request.getRequestDispatcher("/GetPosts");
		rd.forward(request, response);
	}
}
