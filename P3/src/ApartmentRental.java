import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import ui.ScreenRenderer;
import db.JDBCConnectionManager;
import db.managers.LodgingsManager;
import db.managers.UserManager;
import db.models.Lodging;
import db.models.User;

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
		
		allLodgingsExample();
//		createUserExample();
		loginExample();
		
		System.out.println("Done");
	}
	
	/**
	 * 	EXAMPLE USAGE YO
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
	 * 	Give an email and password and get a user instance 
	 */
	private static void loginExample() {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Login");
			
			System.out.print("Enter your email: ");
			String email = scanner.next();
			
			System.out.print("Enter your password: ");
			String password = scanner.next();
			
			UserManager um = new UserManager();
			User user = um.loginUser(email, password);
			
			if (user == null) {
				System.out.println("Invalid login");
				return;
			}
			
			String birthday = user.birthdate != null ? user.birthdate.toString() : "not specified";
			System.out.println(user.firstName + " " + user.lastName + ", birthday: " + birthday);
		}
	}
}
