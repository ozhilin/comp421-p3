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
		} catch (FileNotFoundException e) {
			System.out.println("all lodgings query file was not found");
			e.printStackTrace();
		}
		
		return result;
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