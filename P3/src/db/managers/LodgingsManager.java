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
		
		try {
			Statement stmnt = conn.createStatement();
			
			String selectLodgingsSQL = QueryHelper.findQuery("lodgings/allLodgingsQuery.sql");
			ResultSet rs = stmnt.executeQuery(selectLodgingsSQL);
			
			Lodging l;
			while (rs.next()) {
				l = new Lodging(rs);
				
				result.add(l);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("get all lodgings failed");
		} catch (FileNotFoundException e) {
			System.out.println("all lodgings query file was not found");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public Lodging getLodgingByLid(int lid) {
		Lodging result = null;

		try {
			String query = QueryHelper.findQuery("lodgings/lodgingByLidQuery.sql");
			PreparedStatement stmnt = conn.prepareStatement(query);
			
			stmnt.setInt(1, lid);

			ResultSet rs = stmnt.executeQuery();
			
			rs.next();
			
			return new Lodging(rs);
		} catch (SQLException e) {
			System.out.println("Get lodgings by id failed");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("lodgings by lid query file was not found");
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int createNewLodging(Lodging lodging, User user) {
		// Only a host can create and address MUST be provided.
		if (!user.isLoggedIn() || !user.isHost || lodging.address == null) {
			return -1; 
		}
		
		AddressManager am = new AddressManager();
		int addressId = am.createAddress(lodging.address);
		
		if (addressId == -1) { return -1; }

		try {
			String query = QueryHelper.findQuery("lodgings/createLodging.sql");
			PreparedStatement stmnt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
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
			
			ResultSet rs = stmnt.getGeneratedKeys();
			rs.next();
			return rs.getInt("lid");
		} catch (SQLException e) {
			System.out.println("Create lodging failed");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find createLodgings query");
		}
		
		return -1;
	}
	
	public List<Lodging> getOwnedLodgings(User user) {
		List<Lodging> result = new ArrayList<Lodging>();
		
		try {
			String query = QueryHelper.findQuery("lodgings/ownedLodgingsQuery.sql");
			
			PreparedStatement stmnt = conn.prepareStatement(query);
			stmnt.setString(1, user.email);
			
			ResultSet rs = stmnt.executeQuery(query);
			
			while (rs.next()) {
				result.add(new Lodging(rs));
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