package db.models;

import java.sql.ResultSet;
import java.util.Date;

public class Review {
	public String email;
	public int bid;
	public Date review_date;
	public String review;
	public int rating;
	
	public Review() {}
	
	public Review(ResultSet rs) {
		
	}
}
