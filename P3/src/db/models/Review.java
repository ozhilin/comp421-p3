package db.models;

import java.sql.ResultSet;
import java.util.Date;

import db.util.QueryHelper;

public class Review {
	public String email;
	public int bid;
	public Date reviewDate;
	public String review;
	public int rating;
	
	public Review() {}
	
	public Review(ResultSet rs) {
		this.email = QueryHelper.readString(rs, "email");
		this.bid = QueryHelper.readInt(rs, "bid");
		this.reviewDate = QueryHelper.readDate(rs, "review_date");
		this.review = QueryHelper.readString(rs, "review");
		this.rating = QueryHelper.readInt(rs, "rating");
	}
}
