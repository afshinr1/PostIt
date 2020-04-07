package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Query.QueryModel;

@WebServlet("/CommentControllerQuery")
public class CommentControllerQuery extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private QueryModel qm;
	private int last_event;

	public CommentControllerQuery() {
		super();
		qm = new QueryModel();
		last_event = 0;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Got into CommentControllerQuery doget");

		HttpSession hs = request.getSession();
		String parent = (String) hs.getAttribute("postUUID");
		String post_info = (String) hs.getAttribute("postinfo");

		System.out.println("Post ID: " + parent);
		System.out.println("JAJAJAJ POST INFO" + post_info);
		/* Reads events database, if new events then modify/create comments as needed */

		/* Gets all comments related to the post */
		String comments = qm.getComments(parent, false);

		System.out.println("Last Event: " + last_event + " Comment info: " + comments);

		request.setAttribute("comments", comments);
		request.setAttribute("postinfo", post_info);

		RequestDispatcher rd = request.getRequestDispatcher("thread.jsp");
		rd.forward(request, response);

	}
	
	/*
	 * Uses QueryModel to read events database, modify/create comments as needed,
	 * and return comments/post info to thread.jsp
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Got into CommentControllerQuery doPost after 5 seconds");

		HttpSession hs = request.getSession();
		String parent = (String) hs.getAttribute("postUUID");
		String post_info = (String) hs.getAttribute("postinfo");

		System.out.println("Post ID: " + parent);

		/* Reads events database, if new events then modify/create comments as needed */
		last_event = qm.readEvents(last_event);

		/* Gets all comments related to the post */
		String comments = qm.getComments(parent, false);

		System.out.println("Last Event: " + last_event + " Comment info: " + comments);

		request.setAttribute("comments", comments);
		request.setAttribute("postinfo", post_info);
		
		System.out.println("POST INFO IN POST " + post_info);
		RequestDispatcher rd = request.getRequestDispatcher("thread.jsp");
		rd.forward(request, response);

	}
}
