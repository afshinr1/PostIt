package Query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import connection.GetConnection;
import model.CommentEvent;

public class QueryModel {

	public void performAction(CommentEvent ce) {

		switch (ce.getType()) {

		case "CREATE":
			createComment(ce);
			break;

		case "EDIT":
			editComment(ce);
			break;

		case "DELETE":
			deleteComment(ce);
			break;
		}
	}

	public int readEvents(int last_event) {

		// String sql = "SELECT * FROM events WHERE event_id > ?;";
		String sql = "SELECT * FROM events ORDER BY event_id DESC LIMIT 1;";

		String type;
		String content;
		String uuid;
		String parent;
		int votes;
		String timestamp;
		String username;

		try {

			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			// ps.setInt(1, last_event);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				type = rs.getString("event_type");
				content = rs.getString("comment_content");
				uuid = rs.getString("uuid");
				parent = rs.getString("parent_uuid");
				votes = rs.getInt("votes");
				timestamp = rs.getString("timestamp");
				username = rs.getString("username");
				last_event = rs.getInt("event_id");

				performAction(new CommentEvent(type, content, uuid, parent, votes, timestamp, username));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return last_event;

	}

	public String getComments(String parent_uuid, boolean nest) {

		String comments = "";
		
		String temp;
		String sql = "SELECT * FROM comments WHERE parent_uuid = ?;";

		try {

			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, parent_uuid);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				String content = rs.getString("comment_content");
				String uuid = rs.getString("uuid");
				String parent = rs.getString("parent_uuid");
				int votes = rs.getInt("votes");
				String username = rs.getString("username");

				if(nest)
					temp = "REPLY|" + content + "|" + uuid + "|" + parent + "|" + votes + "|" + username + "*";
				else
					temp = "PARENT|" + content + "|" + uuid + "|" + parent + "|" + votes + "|" + username + "*";
				
				comments += temp;

				if((temp = getComments(uuid, true)).compareTo("") != 0) {
					System.out.println("Comment with uuid: " + uuid + " has nested comments: " + temp);
					comments += temp;
				}
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Comments relating to parent_uuid: " + parent_uuid + " recieved.");
		
		return comments;
	}

	public void createComment(CommentEvent ce) {

		System.out.println("Trying to create new comment...");

		String content = ce.getContent();
		String uuid = ce.getUUID();
		String parent = ce.getParentUUID();
		int votes = ce.getVotes();
		String username = ce.getUsername();

		String sql = "INSERT INTO comments (comment_content, uuid, parent_uuid, votes, username) VALUES (?, ?, ?, ?, ?);";

		try {

			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, content);
			ps.setString(2, uuid);
			ps.setString(3, parent);
			ps.setInt(4, votes);
			ps.setString(5, username);

			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Comment created!");
	}

	public void editComment(CommentEvent ce) {

		String content = ce.getContent();
		String uuid = ce.getUUID();

		String sql = "UPDATE comments SET comment_content = ? WHERE uuid = ?;";

		try {

			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, content);
			ps.setString(2, uuid);

			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Comment edited!");

	}

	public void deleteComment(CommentEvent ce) {

		String uuid = ce.getUUID();

		String sql = "DELETE FROM comments WHERE uuid = ?;";

		try {

			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, uuid);

			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Comment edited!");

	}
}
