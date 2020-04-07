package controller;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Command.CommandModel;

@WebServlet("/CommentControllerCommand")
public class CommentControllerCommand extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CommandModel cm;

	public CommentControllerCommand() {
		super();
		cm = new CommandModel();
	}

	// Calls the CommandModel to create a new create comment event, then returns to
	// PostController passing the Post UUID
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Got into CommentControllerCommand doGet");


		RequestDispatcher rd = request.getRequestDispatcher("/PostController");
		rd.forward(request, response);
	}
	
	// Calls the CommandModel to create a new create comment event, then returns to
	// PostController passing the Post UUID
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("Got into CommentControllerCommand doPost");

		HttpSession hs = request.getSession();
		String username = (String) hs.getAttribute("username");
		String post_info = (String) hs.getAttribute("postinfo");

		String parentUUID = request.getParameter("postUUID");
		String commentInfo = request.getParameter("comment");
		String event_type = request.getParameter("event_type");

		String comm = request.getParameter("content");
		String uuid = request.getParameter("uuid");

		switch (event_type) {

		case "CREATE":
			cm.createCommentEvent(username, parentUUID, commentInfo);
			break;

		case "EDIT":
			System.out.println("Got into EDIT in switch");
			cm.editCommentEvent(username, parentUUID, uuid, commentInfo);
			break;

		case "DELETE":
			System.out.println("Got into DELETE in switch");
			cm.deleteCommentEvent(username, parentUUID, uuid, comm);
			break;
			
		case "REPLY":
			System.out.println("REPLY with info:\nUSERNAME: " + username + "\nParent UUID: " + uuid + "\nComment Info: " + commentInfo);
			cm.createCommentEvent(username, uuid, commentInfo);
			break;

		default:
			System.out.println("Invalid event...");
			break;

		}

		System.out.println("Post info: " + post_info);
		System.out.println("Username: " + username + " Post UUID: " + parentUUID + " Comment Info: " + commentInfo);

		request.setAttribute("postUUID", parentUUID);
		RequestDispatcher rd = request.getRequestDispatcher("/PostController");
		rd.forward(request, response);
	}

}
