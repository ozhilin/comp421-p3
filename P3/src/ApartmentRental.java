import java.sql.Connection;
import ui.ScreenRenderer;
import db.JDBCConnectionManager;

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
		Connection conn = JDBCConnectionManager.getConnection(args[0], args[1]);
		ScreenRenderer screenRenderer = new ScreenRenderer();
		screenRenderer.draw();
		
		System.out.println("Done");
	}
}
