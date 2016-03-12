/**	
 * 
 */
package ui;

public class MainScreen implements IScreen {
	@Override
	public IScreen draw() {
		IScreen nextScreen = null;
		
		System.out.println("Welcome to the apartment rental service, what do you want to do?");
		System.out.println("1) Browse apartments");
		System.out.println("2) Option B");
		System.out.println("3) Option C");
		System.out.println("4) Option D");
		System.out.println("5) Option E");
		System.out.println("q) Quit");
		
		while (nextScreen == null) {
			String input = ScreenRenderer.getUserInput();
			
			nextScreen = handleInput(input);
		}
		
		return nextScreen;
	}

	private IScreen handleInput(String input) {
		switch (input) {
			case "1":
				System.out.println("Option A selected");
				return new ApartmentScreen();
			case "2":
				System.out.println("Option B selected");
				return null;
			case "3":
				System.out.println("Option C selected");
				return null;
			case "4":
				System.out.println("Option D selected");
				return null;
			case "5":
				System.out.println("Option E selected");
				return null;
			case "6":
				System.out.println("Option F selected");
				return null;
			case "q":
				ScreenRenderer.quit();
			default:
				System.out.println("Invalid input!");
		}
		
		return null;
	}
}
