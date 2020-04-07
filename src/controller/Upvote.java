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

@WebServlet("/Upvote")
public class Upvote extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Model model;

	public Upvote() {
		super();
		model = new Model();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("IN UPVOTE CONTROLLER");

		String postUUID = request.getParameter("uuid");
		String votes = request.getParameter("votes");

		System.out.println("postUUID: "+ postUUID + "votes: "+ votes);

		model.upvote(postUUID);

		RequestDispatcher rd = request.getRequestDispatcher("/GetPosts");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("IN UPVOTE CONTROLLER--doPost");
		Connection myConn =  GetConnection.getMySQLConnection();
		HttpSession session = request.getSession();
		
		
		System.out.println("Username while doing upvote: " + session.getAttribute("username"));
		
		
		//String postUUID = (String) session.getAttribute("uuid");
		String postUUID = request.getParameter("uuid");
		String votes = (String) session.getAttribute("votes");
		String username = (String) session.getAttribute("username");
		//System.out.println("!!!!!!!!!!!!!THE USERNAME:"+ username);
		try {

			//to Ensure that not already liked
			String selectQuery = "SELECT * FROM userlikesanddislikes WHERE username = ? AND post_id = ?";
		
			PreparedStatement pStat = myConn.prepareStatement(selectQuery);
			pStat.setString(1, username);
			pStat.setString(2, postUUID);

			ResultSet rs = pStat.executeQuery();
			
			if (!rs.next()) 
			{
				System.out.println("result set was null");
				String addLikeQuery = "INSERT INTO userlikesanddislikes (username, post_id, liked_if_true_disliked_if_false) VALUES (?, ?, ?)";
				PreparedStatement pStatInsert = myConn.prepareStatement(addLikeQuery);
		
				pStatInsert.setString(1, username);
				pStatInsert.setString(2, postUUID);
				//pStat.setString(3, 0);
				pStatInsert.setInt(3, 1);
				
				pStatInsert.executeUpdate();
				model.upvote(postUUID);
			}
			else {
				System.out.println("result set HAS ENTRY");
	            String username1 = rs.getString("username");
	            String post_id = rs.getString("post_id");
	            int liked = rs.getInt("liked_if_true_disliked_if_false");
	            if (liked == 1) 
	            {
	            	System.out.println(username1 + post_id + "liked already");
	            	
	            }
	            else {
		            if (liked == 0) 
		            {
		            	System.out.println(username1 + post_id + " disliked");
		            	String updateQuery = "UPDATE userlikesanddislikes SET liked_if_true_disliked_if_false = ? WHERE username = ? AND post_id = ?";
		            	PreparedStatement pStatUpdate = myConn.prepareStatement(updateQuery);
		            	pStatUpdate.setString(2, username);
		            	pStatUpdate.setString(3, postUUID);
		            	pStatUpdate.setInt(1, 1);
		            	pStatUpdate.executeUpdate();
		            	System.out.println("dislike should be changed");
		            	model.upvote(postUUID);
		            }
	            }
			            
	
			}
			 
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		System.out.println(postUUID + votes);

		

		RequestDispatcher rd = request.getRequestDispatcher("/GetPosts");
		rd.forward(request, response);
		
	}
	

}