package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connection.GetConnection;

public class Topic {

	public String getTopics() {
	String query = "SELECT * FROM topic ORDER BY num_members DESC";
	String data = "";
	Connection myConn = GetConnection.getMySQLConnection();

try {
	Statement myStatement = myConn.createStatement();
	ResultSet myRs = myStatement.executeQuery(query);
	
	while (myRs.next()) {
		
		data += myRs.getString("topic_name");
		data += "|";
		data += myRs.getString("topic_id");
		data += "*";
		
	}
}catch(Exception e) {};
	return data;
	}

}
