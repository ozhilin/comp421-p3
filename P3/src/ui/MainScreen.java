package ui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import db.JDBCConnectionManager;
import db.managers.BookingManager;
import db.managers.CreditCardManager;
import db.managers.LodgingsManager;
import db.managers.ReviewManager;
import db.managers.UserManager;
import db.models.Address;
import db.models.Booking;
import db.models.CreditCard;
import db.models.Lodging;
import db.models.Review;
import db.models.User;

public class MainScreen {

	User mUser;
	Scanner scanner = new Scanner(System.in);

	public void printOptions() {
		if (mUser == null) {
			System.out
					.println("Welcome to the apartment rental service, what do you want to do? Choose an option between 1 and 5 or enter 'q' to quit");
		} else {
			System.out
					.println("Welcome to the apartment rental service "
							+ mUser.firstName
							+ ", what do you want to do? Choose an option between 1 and 5 or enter 'q' to quit");
		}
		System.out.println("1 -> Browse Apartments");
		System.out.println("2 -> Login");
		System.out.println("3 -> Create Account");
		System.out.println("4 -> Update User Account");
		System.out.println("5 -> Book a Lodging"); // todo payments
		System.out.println("6 -> Post a Review");
		System.out.println("7 -> Add a Lodging");
		System.out.println("q -> Quit");
		String choice = scanner.nextLine();
		handleInput(choice);
	}

	private void handleInput(String input) {
		switch (input) {
		case "1":
			allLodgings();
			break;
		case "2":
			login();
			break;
		case "3":
			createUser();
			break;
		case "4":
			if (mUser != null) {
				updateUser(mUser);
			} else {
				System.out
						.println("You must be logged in to proceed, please login using choice 2");
				printOptions();
			}
			break;
		case "5":
			if (mUser != null) {
				createBooking();
			} else {
				System.out
						.println("You must be logged in to proceed, please login using choice 2");
				printOptions();
			}
			break;
		case "6":
			if (mUser != null) {
				postReview();
			} else {
				System.out
						.println("You must be logged in to proceed, please login using choice 2");
				printOptions();
			}
			break;
		case "7":
			if (mUser != null) {
				if (mUser.isHost != true) {
					System.out
							.println("You must be a host to add a lodging. Update your status in choice 4");
					printOptions();
				} else {
					addLodging();
				}
			} else {
				System.out
						.println("You must be logged in to proceed, please login using choice 2");
				printOptions();
			}
			break;
		case "q":
			quit();
		default:
			System.out.println("Invalid input!");
			printOptions();
		}
	}

	private void createUser() {
		System.out.println("Create Account");
		User newUser = new User();

		System.out.print("Enter an email: ");
		newUser.email = scanner.nextLine();

		System.out.print("Enter a password: ");
		newUser.password = scanner.nextLine();

		System.out.print("Enter a first name: ");
		newUser.firstName = scanner.nextLine();

		System.out.print("Enter a last name: ");
		newUser.lastName = scanner.nextLine();

		System.out.print("Enter a birthday: (yyyy-mm-dd) ");
		String string = scanner.nextLine();
		newUser.birthdate = createDate(string);

		System.out.print("Are you a host? (y/n)");
		String input = scanner.nextLine();
		if (input.equalsIgnoreCase("y")) {
			newUser.isHost = true;
		} else if (input.equalsIgnoreCase("n")) {
			newUser.isHost = false;
		}

		System.out.print("Are you a customer? (y/n)");
		input = scanner.nextLine();
		if (input.equalsIgnoreCase("y")) {
			newUser.isCustomer = true;
		} else if (input.equalsIgnoreCase("n")) {
			newUser.isCustomer = false;
		}

		UserManager um = new UserManager();
		um.createUser(newUser);
		System.out.println("Successfully created your account!");
		backToMain();
	}

	private void login() {
		System.out.println("Login");

		System.out.print("Enter your email: ");
		String email = scanner.nextLine();

		System.out.print("Enter your password: ");
		String password = scanner.nextLine();

		UserManager um = new UserManager();
		try {
			mUser = um.loginUser(email, password);
			System.out.println("Welcome " + mUser.firstName + "!");
			backToMain();
		} catch (NullPointerException e) {
			System.out.println("Invalid login");
			backToMain();
		}
	}

	private void updateUser(User user) {
		System.out.println("What would you like to change?");
		System.out.println("1 -> first name");
		System.out.println("2 -> last name");
		System.out.println("3 -> birthdate");
		System.out.println("4 -> host status");
		System.out.println("5 -> customer status");
		String choice = scanner.nextLine();
		switch (choice) {
		case "1":
			System.out.println("Enter a new first name:");
			user.firstName = scanner.nextLine();
			break;
		case "2":
			System.out.println("Enter a new last name:");
			user.lastName = scanner.nextLine();
			break;
		case "3":
			System.out.println("Enter a new birthdate: (yyyy-mm-dd) ");
			String dateString = scanner.nextLine();
			user.birthdate = createDate(dateString);
			break;
		case "4":
			System.out.println("Enter a new host status: (y/n) ");
			String host = scanner.nextLine();
			if (host.equalsIgnoreCase("y")) {
				user.isHost = true;
			} else if (host.equalsIgnoreCase("n")) {
				user.isHost = false;
			}
			break;
		case "5":
			System.out.println("Enter a new customer status: (y/n) ");
			String customer = scanner.nextLine();
			if (customer.equalsIgnoreCase("y")) {
				user.isCustomer = true;
			} else if (customer.equalsIgnoreCase("n")) {
				user.isCustomer = false;
			}
			break;
		default:
			System.out.println("Invalid input!");
			updateUser(user);
		}
		try {
			UserManager um = new UserManager();
			um.updateUser(user);
			System.out.println("Successfully updated user account");
		} catch (NullPointerException e) {
			System.out.println("Error updating user account");
		}

		System.out.println("Would you like to change something else? (y/n)");
		choice = scanner.nextLine();
		if (choice.equalsIgnoreCase("y")) {
			updateUser(user);
		} else {
			backToMain();
		}
	}

	private Date createDate(String dateString) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date date = formatter.parse(dateString);
			return date;

		} catch (ParseException e) {
			System.out.println("Invalid birthdate");
		}
		return null;
	}

	private void allLodgings() {
		System.out.println("Lodgings");
		LodgingsManager alq = new LodgingsManager();
		List<Lodging> lodgings = alq.getAllLodgings();

		for (Lodging l : lodgings) {
			System.out.println(l.lid + ". " + l.name + " -- Rating: "
					+ l.avgRating);
		}
		viewDetails();
		// TODO View details about lodging
	}

	private void viewDetails() {
		while (true) {
			System.out.println("----------------");
			System.out
					.println("Select a lodging number to see the full description, or 'b' to go back to main menu");
			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("b")) {
				printOptions();
			}

			try {
				Connection conn = JDBCConnectionManager.getConnection();
				Statement stmnt = conn.createStatement();

				int lodgingNum = Integer.parseInt(input);
				String getLodgingDescriptionSQL = "SELECT description FROM lodgings WHERE lid = "
						+ lodgingNum;
				ResultSet rs = stmnt.executeQuery(getLodgingDescriptionSQL);

				// TODO : add reviews

				if (rs.next()) {
					String description = rs.getString("description");
					List<Review> reviews = new ArrayList<Review>();
					ReviewManager rm = new ReviewManager();
					reviews = rm.getReviewByLid(lodgingNum);
					System.out.println(description);
					System.out.println("");
					System.out.println("Reviews:");
					for (Review r : reviews) {
						System.out.println(r.review);
						System.out.println();
					}
				} else {
					System.out.println("Lodging was not found!");
				}

				System.out.println("\nView Another lodging? (y/n)");

				if (scanner.nextLine().equalsIgnoreCase("y")) {
					allLodgings();
				} else {
					printOptions();
				}

			} catch (NumberFormatException e) {
				System.out
						.println("Invalid input, is this a valid lodging id?");
			} catch (Exception e) {
				e.printStackTrace();

			}
		}
	}

	private void postReview() {
		System.out.println("Post a Review");
		Review review = new Review();
		review.email = mUser.email;
		System.out.println("Enter your booking id:");
		int bid = scanner.nextInt();
		review.bid = bid;
		System.out.println("Enter your star rating: (between 1 and 5)");
		int rating = scanner.nextInt();
		review.rating = rating;
		System.out.println("Enter your comments:");
		String text = scanner.nextLine();
		review.review = text;
		review.reviewDate = new Date();
		ReviewManager rm = new ReviewManager();
		rm.createNewReview(review, bid, mUser);
		/*
		 * Review r = rm.getReviewByBid(bid);
		 * 
		 * if (!r.email.equals(mUser.email) || !r.rating != rating)) {
		 * System.out.println("Failed posting the review"); } else {
		 * System.out.println("Successfully posted your review!"); }
		 */
		backToMain();
	}

	private void createBooking() {
		System.out.println("Book a Place");
		Booking booking = new Booking();

		LodgingsManager alq = new LodgingsManager();
		List<Lodging> lodgings = alq.getAllLodgings();

		for (Lodging l : lodgings) {
			System.out.println(l.lid + ". " + l.name);
		}
		System.out
				.println("Enter the number of the booking you would like to book: ");
		int lid = scanner.nextInt();
		Lodging l = alq.getLodgingByLid(lid);
		booking.lodging = l;
		System.out.println("Enter FROM date: (yyyy-mm-dd)");
		String from = scanner.nextLine();
		Date fromDate = createDate(from);
		booking.fromDate = fromDate;
		System.out.println("Enter TO date:");
		String to = scanner.nextLine();
		Date toDate = createDate(to);
		booking.toDate = toDate;
		CreditCardManager ccm = new CreditCardManager();
		Map<String, CreditCard> cards = ccm.getPaymentsByUser(mUser);

		for (CreditCard c : cards.values()) {
			System.out.println(c.pid + ". " + c.name + ", expires on "
					+ c.expirationDate);
		}
		System.out.println("Enter your payment id:");
		System.out
				.println("Alternatively, to add a new payment method, enter 'new'");
		String pid = scanner.nextLine();
		if (pid.equalsIgnoreCase("new")) {
			// create payment
			CreditCard cc = new CreditCard();
			cc.email = mUser.email;
			System.out.println("Enter your payment's name:");
			String cname = scanner.nextLine();
			cc.name = cname;
			System.out.println("Enter your billing address:");
			Address a = inputAddress();
			cc.address = a;
			System.out.println("Enter an expiration date: (yyyy-mm-dd");
			String date = scanner.nextLine();
			Date expiration = createDate(date);
			cc.expirationDate = expiration;
			String pid2 = ccm.createNewCreditCard(cc, mUser);
			booking.creditCard = cc;
		} else {
			CreditCard cc = cards.get(pid);
			booking.creditCard = cc;
		}
		// calculate price
		int days = (int) ((toDate.getTime() - fromDate.getTime()) / (1000 * 60 * 60 * 24));
		double price = days * l.dayPrice;
		booking.totalPrice = price;

		BookingManager bm = new BookingManager();
		int bid = bm.createBooking(booking, mUser);
		System.out
				.println("Successfully booked your stay! Your booking ID is : "
						+ bid + " . Please store this number in a safe place.");
		backToMain();
	}

	private void addLodging() {
		System.out.println("Add a lodging");

		String input;
		System.out.println("Enter an address:");
		Address a = inputAddress();

		Lodging l = new Lodging();
		l.address = a;
		l.email = mUser.email;

		System.out.println("Please enter a lodging name:");
		input = scanner.nextLine();
		l.name = input;

		LodgingsManager lm = new LodgingsManager();
		int lid = lm.createNewLodging(l, mUser);

		Lodging l2 = lm.getLodgingByLid(lid);

		if (!l2.email.equals(l.email) || !l2.name.equals(l.name)) {
			System.out.println("Failed creating a lodging");
		} else {
			System.out.println("Successfully added your lodging!");
		}
		backToMain();
	}

	private Address inputAddress() {
		Address a = new Address();
		System.out.print("Street Number: ");
		int number = scanner.nextInt();
		a.num = number;
		System.out.print("Street Name: ");
		String input = scanner.nextLine();
		a.street = input;
		System.out.print("City: ");
		input = scanner.nextLine();
		a.city = input;
		System.out.print("Country: ");
		input = scanner.nextLine();
		a.country = input;
		return a;
	}

	private void backToMain() {
		System.out
				.println("Enter 'b' to go back to the main menu or 'q' to quit");
		String input = scanner.nextLine();
		while (true) {
			if (input.equalsIgnoreCase("b")) {
				printOptions();
				break;
			} else if (input.equalsIgnoreCase("q")) {
				quit();
			} else {
				input = scanner.nextLine();
			}
		}
	}

	private void quit() {
		System.out.println("Bye Bye");
		System.exit(0);
	}
}
