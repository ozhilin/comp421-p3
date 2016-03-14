package db.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import db.util.QueryHelper;

public class Lodging {
	public int lid;
	public int aid;
	public String email;
	public String name;
	public String description;
	public String lodgingType;
	public int numGuests;
	public int numBathrooms;
	public int numBedrooms;
	public int numBeds;
	public String customPolicy;
	public double dayPrice;
	
	public Lodging() {}
	
	public Lodging(ResultSet rs) {
		lid = QueryHelper.readInt(rs, "lid");
		aid = QueryHelper.readInt(rs, "aid");
		email = QueryHelper.readString(rs, "email");
		name = QueryHelper.readString(rs, "name");
		description = QueryHelper.readString(rs, "description");
		lodgingType = QueryHelper.readString(rs, "lodgingType");
		numGuests = QueryHelper.readInt(rs, "num_guests");
		numBathrooms = QueryHelper.readInt(rs, "bathrooms");
		numBeds = QueryHelper.readInt(rs, "beds");
		customPolicy = QueryHelper.readString(rs, "custom_policy");
		dayPrice = QueryHelper.readInt(rs, "day_price");
	}
}
