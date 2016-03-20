package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.models.Review;
import db.models.User;
import db.util.QueryHelper;

public class ReviewManager extends AModelManager {
	public void createNewReview(Review review, int bookingId, User user) {
		// Only a host can create
		if (!user.isLoggedIn()) {
			return;
		}
		
		try {
			String query = QueryHelper.findQuery("reviews/createReview.sql");
			PreparedStatement stmnt = conn.prepareStatement(query);
			
			stmnt.setString(1, user.email);
			stmnt.setInt(2, bookingId);
			stmnt.setDate(3, new java.sql.Date(review.reviewDate.getTime()));
			stmnt.setString(4, review.review);
			stmnt.setInt(5, review.rating);
			
			stmnt.executeUpdate();
			conn.commit();
			
			ResultSet rs = stmnt.getGeneratedKeys();
			rs.next();
		} catch (SQLException e) {
			System.out.println("Create review failed");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find createReview query");
		}
	}

	public List<Review> getReviewByLid(int lid) {
		List<Review> result = new ArrayList<Review>();
		
		try {
			String query = QueryHelper.findQuery("reviews/getReviewsByLid.sql");
			
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setInt(1, lid);
			
			ResultSet rs = stmnt.executeQuery();
			
			while (rs.next()) {
				result.add(new Review(rs));
			}
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		return null;
	}
	
	public Review getReviewByBid(int bid) {
		Review result = new Review();
		
		try {
			String query = QueryHelper.findQuery("reviews/getReviewsByBid.sql");
			
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setInt(1, bid);
			
			ResultSet rs = stmnt.executeQuery();
			
			while (rs.next()) {
				result = new Review(rs);
			}
			
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			
		return null;
	}
}
