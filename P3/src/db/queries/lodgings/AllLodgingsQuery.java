package db.queries.lodgings;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.JDBCConnectionManager;
import db.models.Lodging;

public class AllLodgingsQuery {
	private Connection conn;
	
	public AllLodgingsQuery() {
		try {
			conn = JDBCConnectionManager.getConnection();
		} catch (Exception e) {
			System.out.println("Connection to the database could not be established.");
			e.printStackTrace();
		}
	}
	
	public AllLodgingsQuery(Connection conn) {
		this.conn = conn;
	}
	
	public List<Lodging> getAllLodgings() {
		List<Lodging> result = new ArrayList<Lodging>();
		
		try {
			Statement stmnt = conn.createStatement();
			
			String selectLodgingsSQL = "SELECT * FROM lodgings";
			ResultSet rs = stmnt.executeQuery(selectLodgingsSQL);
			
			Lodging l;
			while (rs.next()) {
				l = new Lodging();
				
				l.lid = rs.getInt("lid");
				l.aid = rs.getInt("aid");
				l.email = rs.getString("email");
				l.name = rs.getString("name");
				l.description = rs.getString("description");
				l.lodgingType = rs.getString("lodging_type");
				l.numGuests = rs.getInt("num_guests");
				l.numBathrooms = rs.getInt("bathrooms");
				l.numBedrooms = rs.getInt("bedrooms");
				l.numBeds = rs.getInt("beds");
				l.customPolicy = rs.getString("custom_policy");
				l.dayPrice = rs.getDouble("day_price");
				
				result.add(l);
			}
		} catch (Exception e) {
			// TODO how to handle?
			e.printStackTrace();
		}
		
		return result;
	}
}
