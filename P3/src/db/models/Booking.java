package db.models;

import java.sql.ResultSet;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import db.util.QueryHelper;

public class Booking {
	public int bid;
	public CreditCard creditCard;
	public Lodging lodging;
	public Date fromDate;
	public Date toDate;
	public double totalPrice;
	
	public Booking() { }
	
	public Booking(Lodging lodging, Date fromDate, Date toDate) {
		this.lodging = lodging;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.lodging = lodging;

		long diff = fromDate.getTime() - toDate.getTime();
		long daysStayed = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		totalPrice = daysStayed;
	}
	
	public Booking(ResultSet rs) {
		bid = QueryHelper.readInt(rs, "bid");
		creditCard = new CreditCard(rs);
		lodging = new Lodging(rs);
		fromDate = QueryHelper.readDate(rs, "from_date");
		toDate = QueryHelper.readDate(rs, "to_date");
		totalPrice = QueryHelper.readDouble(rs, "total_price");
	}
}
