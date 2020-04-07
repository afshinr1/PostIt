package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetConnection {
	private static Connection conn;
	public PreparedStatement pStat;
	public ResultSet myRs;
	
	public static Connection getMySQLConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		//	conn = DriverManager.getConnection("jdbc:mysql://sql3.freesqldatabase.com:3306/sql3327526", "sql3327526", "FgYxT9fCwI");
		//	conn = DriverManager.getConnection("jdbc:mysql://us-cdbr-iron-east-04.cleardb.net:3306/heroku_81c4b46e593a9a7?useSSL=false", "b905936e54a098", "a0f59fd3");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useSSL=false", "root", "kuraikami");
			return conn;
			} 
		
		catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	//	catch (ClassNotFoundException e) {
	//		e.printStackTrace();
	//	}
		return null;
	}
}
