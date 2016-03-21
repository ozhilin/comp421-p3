package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.models.Booking;
import db.models.User;
import db.util.QueryHelper;

public class BookingManager extends AModelManager {
	public int createBooking(Booking booking, User user) {
		if (!user.isLoggedIn()) {
			return -1; 
		}
		
		AddressManager am = new AddressManager();
		try (PreparedStatement createAddressStmnt = am.createAddressStatement(booking.lodging.address)) {
			if (createAddressStmnt == null) return -1;
			
			int aid = -1;
			createAddressStmnt.executeUpdate();
			try (ResultSet rs = createAddressStmnt.getGeneratedKeys()) {
				rs.next();
				aid = rs.getInt("aid");
			}

			if (aid == -1) return -1;
			
			CreditCardManager ccm = new CreditCardManager();
			String pid = ccm.createNewCreditCard(booking.creditCard, user, false); // No need to commit the transaction.
			
			if (pid == "") return -1;
			
			return createBookingWithPaymentMethod(booking, pid, user);
		} catch (SQLException e) { }
		
		return -1;
	}
	
	public int createBookingWithPaymentMethod(Booking booking, String creditCardId, User user) {
		if (!user.isLoggedIn()) {
			return -1; 
		}

		String query;
		try {
			query = QueryHelper.findQuery("bookings/createBooking.sql");
		} catch (FileNotFoundException e1) {
			return -1;
		}
		
		try (PreparedStatement stmnt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmnt.setString(1, creditCardId);
			stmnt.setInt(2, booking.lodging.lid);
			stmnt.setDate(3, new java.sql.Date(booking.fromDate.getTime())); // From date MUST be specified
			stmnt.setDate(4, new java.sql.Date(booking.toDate.getTime())); // From date MUST be specified
			stmnt.setDouble(5, booking.totalPrice);
			
			stmnt.executeUpdate();
			conn.commit();
			
			try (ResultSet rs = stmnt.getGeneratedKeys()) {
				rs.next();
				return rs.getInt("bid");
			}
		} catch (SQLException e) { }		
		return -1;
	}
	
	public List<Booking> viewUserBookings(User user) {
		List<Booking> result = new ArrayList<Booking>();

		String query;
		try {
			query = QueryHelper.findQuery("bookings/bookingsByUser.sql");
		} catch (FileNotFoundException e1) {
			return null;
		}
		
		try (PreparedStatement stmnt = conn.prepareStatement(query)) {
			stmnt.setString(1, user.email);
			
			try (ResultSet rs = stmnt.executeQuery(query)) {
				while (rs.next()) {
					result.add(new Booking(rs));
				}
				
				return result;
			}
		} catch (SQLException e) { } 			

		return null;
	}
}