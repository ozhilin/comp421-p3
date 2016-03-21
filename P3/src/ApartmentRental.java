import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import ui.MainScreen;
import db.JDBCConnectionManager;

/**
 * COMP 421 - Group 40
 * 
 * Dang Khoa Do - 260584925 
 * Yordan Neshev - 260587938 
 * Cecile Robert-Michon -
 * 260552816 Oleg Zhilin - 260581713
 * 
 * Main class for the apartment rental program.
 */

public class ApartmentRental {
	public static Scanner scanner;

	/**
	 * @param args The database password is provided as a command line argument
	 */
	public static void main(String[] args) {
		try (Connection conn = JDBCConnectionManager.getConnection(args[0], args[1])) {
			MainScreen screen = new MainScreen();
			screen.printOptions();

			System.out.println("Done");
		} catch (SQLException e) {
			System.out.println("An error occured while closing the connection!");
		}	
	}
}
