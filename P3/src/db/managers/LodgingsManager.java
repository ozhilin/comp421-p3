package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.models.Lodging;
import db.models.User;
import db.util.QueryHelper;

public class LodgingsManager extends AModelManager {
	
	public List<Lodging> getAllLodgings() {
		List<Lodging> result = new ArrayList<Lodging>();

		String selectLodgingsSQL = "";
		try {
			selectLodgingsSQL = QueryHelper.findQuery("lodgings/allLodgingsQuery.sql");
		} catch (FileNotFoundException e1) {
			return null;
		}
		
		if (selectLodgingsSQL == "") return null;
		
		try (Statement stmnt = conn.createStatement();) {
			try (ResultSet rs = stmnt.executeQuery(selectLodgingsSQL)) {
				while (rs.next()) {
					result.add(new Lodging(rs));
				}
				return result;
			}
		} catch (SQLException e) { } 		

		return null;
	}
	
	public Lodging getLodgingByLid(int lid) {
		String query = "";
		try {
			query = QueryHelper.findQuery("lodgings/lodgingByLidQuery.sql");
		} catch (FileNotFoundException e1) {
			return null;
		}
		
		if (query == "") return null;

		try (PreparedStatement stmnt = conn.prepareStatement(query);) {
			stmnt.setInt(1, lid);

			try (ResultSet rs = stmnt.executeQuery()) {
				rs.next();
				return new Lodging(rs);
			}
		} catch (SQLException e) { } 		

		return null;
	}
	
	public int createNewLodging(Lodging lodging, User user) {
		// Only a host can create and address MUST be provided.
		if (!user.isLoggedIn() || !user.isHost || lodging.address == null) {
			return -1; 
		}
		
		AddressManager am = new AddressManager();
		int addressId = am.createAddress(lodging.address);
		
		if (addressId == -1) return -1; 

		String query = "";
		try {
			query = QueryHelper.findQuery("lodgings/createLodging.sql");
		} catch (FileNotFoundException e1) {
			return -1;
		}

		if (query == "") return -1;

		try (PreparedStatement stmnt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
			stmnt.setInt(1, addressId);
			stmnt.setString(2, user.email);
			stmnt.setString(3, lodging.name);
			stmnt.setString(4, lodging.description);
			stmnt.setString(5, lodging.lodgingType);
			stmnt.setInt(6, lodging.numGuests);
			stmnt.setInt(7, lodging.numBathrooms);
			stmnt.setInt(8, lodging.numBedrooms);
			stmnt.setInt(9, lodging.numBeds);
			stmnt.setString(10, lodging.customPolicy);
			stmnt.setDouble(11, lodging.dayPrice);
			
			stmnt.executeUpdate();
			conn.commit();
			
			try (ResultSet rs = stmnt.getGeneratedKeys()) {
				rs.next();
				return rs.getInt("lid");
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) { }
		} 		

		return -1;
	}
	
	public List<Lodging> getOwnedLodgings(User user) {
		List<Lodging> result = new ArrayList<Lodging>();

		String query = "";
		try {
			query = QueryHelper.findQuery("lodgings/ownedLodgingsQuery.sql");
		} catch (FileNotFoundException e1) { 
			return null;
		}

		try (PreparedStatement stmnt = conn.prepareStatement(query);) {
			stmnt.setString(1, user.email);
			
			try (ResultSet rs = stmnt.executeQuery()) {
				while (rs.next()) {
					result.add(new Lodging(rs));
				}
				
				return result;
			}
		} catch (SQLException e) { } 			

		return null;
	}
}