/**
 * 
 */
package ui;

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
				return null;
			default:
				ScreenRenderer.quit();
		}
		return null;
	}
}
