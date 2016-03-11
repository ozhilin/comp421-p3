import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.SimpleJDBC;

/**	
 * 	COMP 421 - Group 40
 * 	
 * 	Dang Khoa Do - 260584925
 * 	Yordan Neshev - 260587938
 * 	Cécile Robert-Michon - 260552816
 * 	Oleg Zhilin - 260581713
 * 
 * 	Main class for the apartment rental program.
 */

public class ApartmentRental {

	/**
	 * @param args The database password is provided as a command line argument 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(args[0]);
		
		Connection conn = SimpleJDBC.initializeDbConnection(args[0], args[1]);
		test(conn);
	}

	private static void test(Connection con) {
		// Querying a table
		try {
				Statement statement = con.createStatement ();
			
		    String querySQL = "SELECT * FROM Employees'";
		    System.out.println (querySQL) ;
		    java.sql.ResultSet rs = statement.executeQuery ( querySQL ) ;
		    while ( rs.next ( ) ) {
			int id = rs.getInt ( 1 ) ;
			String name = rs.getString (2);
			System.out.println ("id:  " + id);
			System.out.println ("name:  " + name);
		    }
		    System.out.println ("DONE");
		} catch (SQLException e)
		    {
			int sqlCode = e.getErrorCode(); // Get SQLCODE
			String sqlState = e.getSQLState(); // Get SQLSTATE

		    // Your code to handle errors comes here;
		    // something more meaningful than a print would be good
		    System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
	      }
	}
}
