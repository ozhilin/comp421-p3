package db.managers;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.models.Lodging;
import db.util.QueryHelper;

public class LodgingsManager extends AModelManager {
	
	public List<Lodging> getAllLodgings() {
		List<Lodging> result = new ArrayList<Lodging>();
		
		try {
			Statement stmnt = conn.createStatement();
			
			String selectLodgingsSQL = QueryHelper.findQuery("lodgings/allLodgingsQuery.sql");
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
			e.printStackTrace();
		}
		
		return result;
	}
}
