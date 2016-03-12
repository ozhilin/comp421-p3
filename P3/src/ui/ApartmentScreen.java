/**
 * 
 */
package ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import db.JDBCConnectionManager;

public class ApartmentScreen implements IScreen {

	@Override
	public IScreen draw() {
		IScreen nextScreen = null;
		
		System.out.println("----------------------------------");
		System.out.println("VIEW APARTMENTS");
		System.out.println("1) View all apartments");
		System.out.println("q) Quit");
		
		while (nextScreen == null) {
			String input = ScreenRenderer.getUserInput();
			
			nextScreen = handleInput(input);
		}
		
		return nextScreen;
	}

	private IScreen handleInput(String input) {
		switch(input) {
			case "1":
				System.out.println("View all apartments");
				displayAllLodgings();
				subMenu();
				return new MainScreen();
			default:
				ScreenRenderer.quit();
		}
		return null;
	}

	public void displayAllLodgings() {
		Connection conn;
		try {
			conn = JDBCConnectionManager.getConnection();
			Statement stmnt = conn.createStatement();
			
			String selectLodgingsSQL = "SELECT lid, name, SUBSTRING(description, 0, 20) || '...' AS description FROM lodgings";
			ResultSet rs = stmnt.executeQuery(selectLodgingsSQL);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString("name");
				String description = rs.getString("description");
				
				System.out.println(id + ", " + name + ", " + description);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void subMenu() {
		while (true) {
			System.out.println("----------------");
			System.out.println("Select a lodging number to see the full description, or \"q\" to exit");
			String input = ScreenRenderer.getUserInput();
			
			if (input.equalsIgnoreCase("q")) {
				break;
			}
			
			try {
				Connection conn = JDBCConnectionManager.getConnection();
				Statement stmnt = conn.createStatement();
				
				int lodgingNum = Integer.parseInt(input);
				String getLodgingDescriptionSQL = "SELECT description FROM lodgings WHERE lid = " + lodgingNum;
				ResultSet rs = stmnt.executeQuery(getLodgingDescriptionSQL);
				
				if (rs.next()) {
					String description = rs.getString("description");
					System.out.println(description);
				} else {
					System.out.println("Lodging was not found!");
				}
				
				System.out.println("\nView Another lodging? [y/n]");
				
				if (!ScreenRenderer.getUserInput().equalsIgnoreCase("y")) {
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid input, is this a valid lodging id?");
			} catch (Exception e) {
				e.printStackTrace();
				ScreenRenderer.quit();
			}
		}
	}
}
