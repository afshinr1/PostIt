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

import model.Command;

/**
 * Servlet implementation class PostControllerCommand
 */
@WebServlet("/PostControllerCommand")
public class PostControllerCommand extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostControllerCommand() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Got into post controller POST");
		Command newCommentCommand = new Command();

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
 				
		HttpSession sess = request.getSession();
		String username = (String) sess.getAttribute("username");	
		String parentUUID = request.getParameter("postUUID");
		String commentInfo =request.getParameter("comment");
		System.out.println("PARENT UUID :" + parentUUID + "\n comment info" + commentInfo);
		
		newCommentCommand.createEvent(randomUUIDString, username, parentUUID, commentInfo);
		
		request.setAttribute("parentUUID", parentUUID);
		RequestDispatcher rd = request.getRequestDispatcher("/PostController");
		rd.forward(request,response);
	}

}
