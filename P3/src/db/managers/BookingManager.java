package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.models.Booking;
import db.models.User;
import db.util.QueryHelper;

public class BookingManager extends AModelManager {
	public int createBooking(Booking booking, User user) {
		if (!user.isLoggedIn()) {
			return -1; 
		}
		
		AddressManager am = new AddressManager();
		int addressId = am.createAddress(booking.lodging.address);
		
		if (addressId == -1) { return -1; }

		try {
			String query = QueryHelper.findQuery("lodgings/createBooking.sql");
			PreparedStatement stmnt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			stmnt.setInt(1, booking.pid);
			stmnt.setInt(2, booking.lodging.lid);
			stmnt.setDate(3, new java.sql.Date(booking.fromDate.getTime()));
			stmnt.setDate(4, new java.sql.Date(booking.toDate.getTime()));
			stmnt.setDouble(5, booking.totalPrice);
			
			stmnt.executeUpdate();
			conn.commit();
			
			ResultSet rs = stmnt.getGeneratedKeys();
			rs.next();
			return rs.getInt("bid");
		} catch (SQLException e) {
			System.out.println("Create booking failed");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find createBooking query");
		}
		
		return -1;
	}
}