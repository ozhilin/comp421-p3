package db.models;

import java.sql.ResultSet;
import java.util.Date;

import db.util.QueryHelper;

/**
 *  The CreditCard class merges the information in PaymentAccounts and CreditCards.
 */
public class CreditCard {
	public String pid;
	public String email;
	public String name;
	public Address address;
	public Date expirationDate;
	
	public CreditCard() { }
	
	public CreditCard(ResultSet rs) {
		pid = QueryHelper.readString(rs, "pid");
		email = QueryHelper.readString(rs, "email");
		name = QueryHelper.readString(rs, "name");
		address = new Address(rs);
		expirationDate = QueryHelper.readDate(rs, "expiration_date");
	}
}
