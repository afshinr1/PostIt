package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Model;

/**
 * Servlet implementation class SearchPostController
 */
@WebServlet("/SearchPostController")
public class SearchPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPostController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Search post controller GET");
		String postName = (String) request.getParameter("postName");
		Model model = new Model();
		System.out.println("post name search: " + postName);
		
		HttpSession session = request.getSession();
		String topicId = (String) session.getAttribute("TopicId");
		System.out.println("TOPIC ID IN GET POSTS:" + topicId);

		String info;
		info = model.searchPosts(postName, topicId);
		String image = model.getImage();
		request.setAttribute("image", image);
		System.out.println(info);
		request.setAttribute("allPosts", info);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
		
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
