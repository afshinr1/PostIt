package Command;

import java.sql.*;
import java.util.UUID;

import connection.GetConnection;

public class CommandModel {
	
	public String createCommentEvent(String username, String parent_uuid, String comment_info) {
		
		System.out.println("Trying to create new comment event...");
		
		UUID u = UUID.randomUUID();
		String uuid = u.toString();
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String ts = timestamp.toString();
		
		String sql = "INSERT INTO events (event_type, comment_content, uuid, parent_uuid, votes, timestamp, username) VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		try {
		
			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "CREATE");
			ps.setString(2, comment_info);
			ps.setString(3, uuid);
			ps.setString(4, parent_uuid);
			ps.setInt(5, 0);
			ps.setString(6, ts);
			ps.setString(7, username);
			
			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("New create comment event");
		
		return uuid;
	}
	
	public String deleteCommentEvent(String username, String parent_uuid, String uuid, String comment_info) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String ts = timestamp.toString();
		
		String sql = "INSERT INTO events (event_type, comment_content, uuid, parent_uuid, votes, timestamp, username) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "DELETE");
			ps.setString(2, comment_info);
			ps.setString(3, uuid);
			ps.setString(4, parent_uuid);
			ps.setInt(5, 0);
			ps.setString(6, ts);
			ps.setString(7, username);

			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("New delete comment event");
		
		return uuid;
	}
	
	public String editCommentEvent(String username, String parent_uuid, String uuid, String comment_info) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String ts = timestamp.toString();
		
		String sql = "INSERT INTO events (event_type, comment_content, uuid, parent_uuid, votes, timestamp, username) VALUES (?, ?, ?, ?, ?, ?, ?);";
		
		try {
			Connection conn = GetConnection.getMySQLConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "EDIT");
			ps.setString(2, comment_info);
			ps.setString(3, uuid);
			ps.setString(4, parent_uuid);
			ps.setInt(5, 0);
			ps.setString(6, ts);
			ps.setString(7, username);

			if (ps.executeUpdate() == 2) {
				System.out.println("Error inserting user data into database...");
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("New edit comment event");
		
		return uuid;
	}
	
	
}
