/**
 * 
 */
package ui;

import java.util.Scanner;

public class ScreenRenderer {
	private IScreen currentScreen;
	
	public ScreenRenderer() {
		currentScreen = new MainScreen();
	}
	
	public void draw() {
		while(currentScreen != null) {
			currentScreen = currentScreen.draw();			
		}
	}
	
	public static String getUserInput() {
		Scanner scanner = new Scanner (System.in);  
		return scanner.next(); // Get what the user types.
	}
	
	public static void quit() {
		// TODO close connections here
		System.exit(0);
	}
}
