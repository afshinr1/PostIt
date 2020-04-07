package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.GetConnection;

public class Query {

public String getComments(String postUuid) {
	String data = "";
	String query = "SELECT * FROM comments WHERE parent_uuid = ?";
	Connection myConn;
	try {
		myConn = GetConnection.getMySQLConnection();

		PreparedStatement pStat = myConn.prepareStatement(query);
		pStat.setString(1, postUuid);

		ResultSet rs = pStat.executeQuery();
		
		while(rs.next()) {
			data+=rs.getString("comment_content");
			data+= "|";
			data+= rs.getString("uuid");
			data+="|";
			data+=rs.getString("parent_uuid");
			data+= "|";
			data+=rs.getString("username");
			data+= "*";
		}
	} catch (Exception e) {
		e.printStackTrace();
	}

	return data;
	}

public void checkEvents() {
if (EventStream.events.size() >= 0 &&  EventStream.events.size() > EventStream.timestamp) {
	EventStream.timestamp++;
	int newEvents = EventStream.events.size() - 1;
	
	//Add new event to database
	Event newEvent = EventStream.events.get(newEvents);
	
	Connection myConn;
	String query = "INSERT INTO comments (event_type, comment_content, uuid, parent_uuid, username, votes) VALUES (?, ?, ?, ?, ?, ?)";

	try {
		myConn = GetConnection.getMySQLConnection();

		PreparedStatement pStat = myConn.prepareStatement(query);

		pStat.setString(1, "CREATE");
		pStat.setString(2, newEvent.commentInfo);
		pStat.setString(3, newEvent.commentUUID);
		pStat.setString(4, newEvent.parentUUID);
		pStat.setString(5, newEvent.username);
		pStat.setInt(6, 5);

		pStat.executeUpdate();

	} catch (Exception e) {
		e.printStackTrace();
	}
}
	
}
	
}
