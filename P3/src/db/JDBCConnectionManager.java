package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 	@author Oleg
 *
 *	Test class for connecting to the database on postgres
 */
public class JDBCConnectionManager {
	private static String url =  "jdbc:postgresql://comp421.cs.mcgill.ca:5432/cs421?connectTimeout=3";
	
	private static Connection conn;
	
	/**
	 * 	Registers the driver and makes the connection.
	 */
	public static Connection initializeDbConnection(String username, String password) {
		if (conn != null) {
			return conn;
		}
		
	    try {
    		DriverManager.registerDriver(new org.postgresql.Driver());
	      	Connection con = DriverManager.getConnection(url, username, password);
	      	conn = con;
	      	
	      	System.out.println("Connection Successful");
	    } catch (Exception e) {
	    	System.out.println("Connection could not be established");
	    	e.printStackTrace();
	    }
	    
	    return conn;
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn = null;
		}
	}
}
