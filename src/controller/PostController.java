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

@WebServlet("/PostController")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Model model;

	public PostController() {
		super();
		model = new Model();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Got into post controller GET");
		String title = request.getParameter("title");
		String desc = request.getParameter("desc");
		String postuuid = request.getParameter("postUUID");

		
		
		HttpSession session = request.getSession();

	
		String postInfo = title + "|" + desc + "|" + model.getUsername(postuuid);

		session.setAttribute("postUUID", postuuid);
		session.setAttribute("postinfo", postInfo);
		
		System.out.println("POST INFOOOOOO: " + postInfo);
		System.out.println("Post UUID: " + postuuid);

		RequestDispatcher rd = request.getRequestDispatcher("/CommentControllerQuery");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("Got into post controller POST");

		HttpSession session = request.getSession();

		String postuuid = request.getParameter("postUUID");

		String postInfo = model.getPostInfo(postuuid);
		session.setAttribute("postUUID", postuuid);
		session.setAttribute("postinfo", postInfo);

		System.out.println("Post UUID: " + postuuid);

		RequestDispatcher rd = request.getRequestDispatcher("/CommentControllerQuery");
		rd.forward(request, response);
	}

}
