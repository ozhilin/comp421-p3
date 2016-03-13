import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import ui.ScreenRenderer;
import db.JDBCConnectionManager;
import db.managers.LodgingsManager;
import db.managers.UserManager;
import db.models.Lodging;
import db.models.User;

/**
 * COMP 421 - Group 40
 * 
 * Dang Khoa Do - 260584925 
 * Yordan Neshev - 260587938 
 * Cécile Robert-Michon -
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
		// Establish db connection
		Connection conn = JDBCConnectionManager.getConnection(args[0], args[1]);

		// Scanner needs to be passed around otherwise it closes system in
		scanner = new Scanner(System.in); 

		allLodgingsExample();
		// createUserExample();
		User user = loginExample();
		updateExample(user);

		scanner.close();

		System.out.println("Done");
	}

	/**
	 * EXAMPLE USAGE YO
	 */
	private static void allLodgingsExample() {
		LodgingsManager alq = new LodgingsManager();
		List<Lodging> lodgings = alq.getAllLodgings();

		for (Lodging l : lodgings) {
			System.out.println(l.lid + ", " + l.name);
		}
	}

	private static void createUserExample() {
		try (Scanner scanner = new Scanner(System.in)) {
			User newUser = new User();

			System.out.print("Enter an email: ");
			newUser.email = scanner.next();

			System.out.print("Enter a password: ");
			newUser.password = scanner.next();

			System.out.print("Enter a first name: ");
			newUser.firstName = scanner.next();

			System.out.print("Enter a last name: ");
			newUser.lastName = scanner.next();

			UserManager um = new UserManager();
			um.createUser(newUser);
		}
	}

	/*
	 * Give an email and password and get a user instance
	 */
	private static User loginExample() {
		System.out.println("Login");

		System.out.print("Enter your email: ");
		String email = scanner.next();

		System.out.print("Enter your password: ");
		String password = scanner.next();

		UserManager um = new UserManager();
		User user = um.loginUser(email, password);

		if (user == null) {
			System.out.println("Invalid login");
			return null;
		}

		String birthday = user.birthdate != null ? user.birthdate.toString() : "not specified";
		System.out.println(user.firstName + " " + user.lastName	+ ", birthday: " + birthday);

		return user;
	}

	private static void updateExample(User user) {
		System.out.println("Update");
		System.out.println("Enter a new birthdate: (yyyy-mm-dd) ");

		String dateString = scanner.next();
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatter.parse(dateString);

			// Add this to some helper probably
			user.birthdate = new java.sql.Date(date.getTime());
			UserManager um = new UserManager();
			um.updateUser(user);
		} catch (ParseException e) {
			System.out.println("Invalid birthdate");
		}
	}
}
