package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.GetConnection;

public class Model {

	/* STUFF FOR SUBSCRIPTIONS */

	public void subscribeUser(String username, String topic_id) {

		String sql = "INSERT INTO usersubs (username, topic_id) VALUES (?, ?);";

		try {

			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, topic_id);

			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("User and topic inserted into usersubs!");

		increaseNumMembers(topic_id);
	}

	public void increaseNumMembers(String topic_id) {

		String sql = "UPDATE topic SET num_members = num_members + 1 WHERE topic_id = ?;";

		try {

			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, topic_id);

			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Topic ID: " + topic_id + " num_members incremented!");
	}

	/* GETTING TOPIC STUFF */

	public String getTopics() {

		String query = "SELECT * FROM topic ORDER BY num_members DESC";
		String data = "";

		try {

			Connection myConn = GetConnection.getMySQLConnection();
			Statement myStatement = myConn.createStatement();
			ResultSet myRs = myStatement.executeQuery(query);

			while (myRs.next()) {

				data += myRs.getString("topic_name");
				data += "|";
				data += myRs.getString("topic_id");
				data += "|";
				data += myRs.getString("num_members");
				data += "*";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	/* UPVOTE */

	public void upvote(String uuid) {

		String sql = "UPDATE posts SET votes = votes + 1 WHERE uuid = ?;";

		try {

			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uuid);

			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Post with UUID: " + uuid + " votes incremented!");
	}

	/* DOWNVOTE */

	public void downvote(String uuid) {

		String sql = "UPDATE posts SET votes = votes - 1 WHERE uuid = ?;";

		try {

			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, uuid);

			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			}

			

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Post with UUID: " + uuid + " votes decremented!");
	}

	/* STUFF TO GET POSTS WITH */

	public String getPosts(String topicId) {
		String query = "SELECT * FROM posts WHERE topic_id = ?";
		Connection myConn;
		String topic = "";
		String data = "";
		int topicIdInt = Integer.parseInt(topicId);
		try {
			myConn = GetConnection.getMySQLConnection();
			PreparedStatement pStat1 = myConn.prepareStatement(query);
			pStat1.setInt(1, topicIdInt);

			ResultSet myRs = pStat1.executeQuery();
			ResultSet myRs2;

			while (myRs.next()) {
				int votes = myRs.getInt("votes");
				int postId = myRs.getInt("post_id");
				String postContent = myRs.getString("post_content");
				int topic_id = myRs.getInt("topic_id");
				String user_id = myRs.getString("username");
				String title = myRs.getString("title");
				String uuid = myRs.getString("uuid");
				String query2 = "SELECT * FROM topic AS t WHERE t.topic_id = ?";
				PreparedStatement pStat = myConn.prepareStatement(query2);
				pStat.setInt(1, topic_id);
				myRs2 = pStat.executeQuery();
				if (myRs2.next()) {
					topic = myRs2.getString("topic_name");
				}
				data += postId + "," + votes + "," + topic + "," + postContent + "," + user_id + "," + title + ","
						+ uuid;
				data += "*";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	public String getImage() {
		String query = "SELECT * FROM images";
		String images = "";
		Connection myConn = GetConnection.getMySQLConnection();

		try {
			Statement myStatement = myConn.createStatement();
			ResultSet myRs = myStatement.executeQuery(query);
			while (myRs.next()) {
				images += myRs.getString("image");
				images += "*";
			}
		} catch (Exception e) {
		}
		;
		return images;
	}

	public String getUsername(String postuuid) {
		String query = "SELECT * FROM posts WHERE uuid = ?";
		Connection myConn;
		String username = "";

		try {
			myConn = GetConnection.getMySQLConnection();

			PreparedStatement pStat = myConn.prepareStatement(query);
			pStat.setString(1, postuuid);

			ResultSet rs = pStat.executeQuery();
			while (rs.next()) {
				username = rs.getString("username");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return username;
	}

	public void createNewPost(String postContent, String username, int topicID, String uuid, int votes, String title) {
		Connection myConn;
		String query = "INSERT INTO posts (post_content, username , topic_id, uuid, votes, title) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			System.out.println("NEW POST USERNAME  " + username);
			
			myConn = GetConnection.getMySQLConnection();

			PreparedStatement pStat = myConn.prepareStatement(query);

			pStat.setString(1, postContent);
			pStat.setString(2, username);
			pStat.setInt(3, topicID);
			pStat.setString(4, uuid);
			pStat.setInt(5, votes);
			pStat.setString(6, title);

			pStat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/* STUFF FOR USER RELATED THINGS */

	public boolean validateUser(String username, String pass) {
		String query = "SELECT * FROM users WHERE username = ? AND user_pwd = ?";
		Connection myConn;
		try {
			myConn = GetConnection.getMySQLConnection();

			PreparedStatement pStat = myConn.prepareStatement(query);
			pStat.setString(1, username);
			pStat.setString(2, pass);

			ResultSet rs = pStat.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean checkUserExist(String username) {

		String query = "SELECT * FROM users WHERE username = ?";
		Connection myConn;
		try {
			myConn = GetConnection.getMySQLConnection();

			PreparedStatement pStat = myConn.prepareStatement(query);
			pStat.setString(1, username);

			ResultSet rs = pStat.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public void addUser(String uName, String pwd, String email) {
		Connection myConn;
		String query = "INSERT INTO users (username, user_pwd, user_email) VALUES (?, ?, ?)";

		try {
			myConn = GetConnection.getMySQLConnection();

			PreparedStatement pStat = myConn.prepareStatement(query);

			pStat.setString(1, uName);
			pStat.setString(2, pwd);
			pStat.setString(3, email);
			pStat.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getPostInfo(String postuuid) {
		String data = "";
		String query = "SELECT * FROM posts WHERE uuid = ?";

		try {

			Connection myConn = GetConnection.getMySQLConnection();
			PreparedStatement pStat1 = myConn.prepareStatement(query);
			pStat1.setString(1, postuuid);

			ResultSet myRs = pStat1.executeQuery();
			
			while (myRs.next()) {
				data += myRs.getString("title");
				data += "|";
				data += myRs.getString("post_content");
				data += "|";
				data += myRs.getString("username");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}

	public void createNewTopic(String title) {
		String sql = "INSERT INTO topic (topic_name, num_members) VALUES (?, ?);";
		System.out.println("INSIDE SQL, trying to insert new topic");
		try {

			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setInt(2, 0);

			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			}
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		
	}

	public String getEmail(String uName) {
		String data = "";
		String query = "SELECT * FROM users WHERE username = ?";

		try {

			Connection myConn = GetConnection.getMySQLConnection();
			PreparedStatement pStat1 = myConn.prepareStatement(query);
			pStat1.setString(1, uName);

			ResultSet myRs = pStat1.executeQuery();
			
			while (myRs.next()) {
				data = myRs.getString("user_email");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Data" + data);
		return data;	
		}

	public String SearchTopics(String topicName) {
		
		String data = "";
		String query = "SELECT * FROM topic WHERE topic_name = ?";

		try {

			Connection myConn = GetConnection.getMySQLConnection();
			PreparedStatement pStat1 = myConn.prepareStatement(query);
			pStat1.setString(1, topicName);

			ResultSet myRs = pStat1.executeQuery();
			
			while (myRs.next()) {
				data += myRs.getString("topic_name");
				data += "|";
				data += myRs.getString("topic_id");
				data += "|";
				data += myRs.getString("num_members");
				data += "*";
			
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Data" + data);
		return data;	
		
	}

	public String searchPosts(String postName, String topicId) {
		String query = "SELECT * FROM posts WHERE topic_id = ? AND title = ?";
		Connection myConn;
		String topic = "";
		String data = "";
		int topicIdInt = Integer.parseInt(topicId);
		try {
			myConn = GetConnection.getMySQLConnection();
			PreparedStatement pStat1 = myConn.prepareStatement(query);
			pStat1.setInt(1, topicIdInt);
			pStat1.setString(2, postName);
			ResultSet myRs = pStat1.executeQuery();
			ResultSet myRs2;

			while (myRs.next()) {
				int votes = myRs.getInt("votes");
				int postId = myRs.getInt("post_id");
				String postContent = myRs.getString("post_content");
				int topic_id = myRs.getInt("topic_id");
				String user_id = myRs.getString("username");
				String title = myRs.getString("title");
				String uuid = myRs.getString("uuid");
				String query2 = "SELECT * FROM topic AS t WHERE t.topic_id = ?";
				PreparedStatement pStat = myConn.prepareStatement(query2);
				pStat.setInt(1, topic_id);
				myRs2 = pStat.executeQuery();
				if (myRs2.next()) {
					topic = myRs2.getString("topic_name");
				}
				data += postId + "," + votes + "," + topic + "," + postContent + "," + user_id + "," + title + ","
						+ uuid;
				data += "*";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	
	}


}
