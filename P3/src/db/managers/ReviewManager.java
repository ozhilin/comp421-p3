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
		if (!user.isLoggedIn()) {
			return;
		}
		
		String query;
		try {
			query = QueryHelper.findQuery("reviews/createNewReview.sql");
		} catch (FileNotFoundException e1) {
			return;
		}

		try (PreparedStatement stmnt = conn.prepareStatement(query);) {
			stmnt.setString(1, user.email);
			stmnt.setInt(2, bookingId);
			stmnt.setDate(3, new java.sql.Date(review.reviewDate.getTime()));
			stmnt.setString(4, review.review);
			stmnt.setInt(5, review.rating);
			
			stmnt.executeUpdate();
			conn.commit();
		} catch (SQLException e) { } 	
	}

	public List<Review> getReviewByLid(int lid) {
		List<Review> result = new ArrayList<Review>();

		String query;
		try {
			query = QueryHelper.findQuery("reviews/getReviewsByLid.sql");
		} catch (FileNotFoundException e1) {
			return null;
		}
		
		try (PreparedStatement stmnt = conn.prepareStatement(query);) {
			stmnt.setInt(1, lid);
			
			try (ResultSet rs = stmnt.executeQuery()) {
				while (rs.next()) {
					result.add(new Review(rs));
				}
				
				return result;
			}
		} catch (SQLException e) { } 			

		return null;
	}
	
	public Review getReviewByBid(int bid) {
		Review result = new Review();
		
		String query;
		try {
			query = QueryHelper.findQuery("reviews/getReviewsByBid.sql");
		} catch (FileNotFoundException e1) {
			return null;
		}

		try (PreparedStatement stmnt = conn.prepareStatement(query);) {
			stmnt.setInt(1, bid);
			
			try (ResultSet rs = stmnt.executeQuery()) {
				while (rs.next()) {
					result = new Review(rs);
				}
				
				return result;
			}
		} catch (SQLException e) { } 			

		return null;
	}
}
