package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connection.GetConnection;
import model.Model;

@WebServlet("/Downvote")
public class Downvote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;

	public Downvote() {
		super();
		model = new Model();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("IN DOWNVOTE CONTROLLER");

		String postUUID = request.getParameter("uuid");
		String votes = request.getParameter("votes");

		System.out.println(postUUID + votes);

		model.downvote(postUUID);

		RequestDispatcher rd = request.getRequestDispatcher("/GetPosts");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("IN DOWNVOTE CONTROLLER");
		Connection myConn =  GetConnection.getMySQLConnection();
		HttpSession session = request.getSession();
				
		System.out.println("Username while doing downvote: " + session.getAttribute("username"));
		
		
		
		String postUUID = request.getParameter("uuid");
		String votes = (String) session.getAttribute("votes");
		String username = (String) session.getAttribute("username");
		
		try {

			//to Ensure that not already disliked
			String selectQuery = "SELECT * FROM userlikesanddislikes WHERE username = ? AND post_id = ?";
		
			PreparedStatement pStat = myConn.prepareStatement(selectQuery);
			pStat.setString(1, username);
			pStat.setString(2, postUUID);

			ResultSet rs = pStat.executeQuery();
			
			if (!rs.next()) 
			{
				System.out.println("result set was null");
				String addDislikeQuery = "INSERT INTO userlikesanddislikes (username, post_id, liked_if_true_disliked_if_false) VALUES (?, ?, ?)";
				PreparedStatement pStatInsert = myConn.prepareStatement(addDislikeQuery);
		
				pStatInsert.setString(1, username);
				pStatInsert.setString(2, postUUID);
				pStatInsert.setInt(3, 0);
				
				pStatInsert.executeUpdate();
				model.downvote(postUUID);
			}
			else {
				System.out.println("result set HAS ENTRY");
	            String username1 = rs.getString("username");
	            String post_id = rs.getString("post_id");
	            int liked = rs.getInt("liked_if_true_disliked_if_false");
	            if (liked == 0) 
	            {
	            	System.out.println(username1 + " "+ post_id + " disliked already");
	            	
	            }
	            else {
		            if (liked == 1) 
		            {
		            	System.out.println(username1 + post_id + " Liked");
		            	String updateQuery = "UPDATE userlikesanddislikes SET liked_if_true_disliked_if_false = ? WHERE username = ? AND post_id = ?";
		            	PreparedStatement pStatUpdate = myConn.prepareStatement(updateQuery);
		            	pStatUpdate.setString(2, username);
		            	pStatUpdate.setString(3, postUUID);
		            	pStatUpdate.setInt(1, 0);
		            	pStatUpdate.executeUpdate();
		            	System.out.println("dislike should be changed");
		            	model.downvote(postUUID);
		            }
	            }
			            
	
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/GetPosts");
		rd.forward(request, response);
	}

}