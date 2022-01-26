package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionDB {
	
	public static Connection getConnection() throws SQLException {
		
		Connection con  = null;
		
		String user = "bankdb";
		String pwd = "123"; 
		String service = "localhost";
		String url = "jdbc:oracle:thin:";
		
		url += user + "/" + pwd + "@" + service;
		
		con = DriverManager.getConnection(url);
		
		return con;
	}

}
