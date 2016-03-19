package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.models.Address;
import db.util.QueryHelper;

public class AddressManager extends AModelManager {
	public Address getAddress(int aid) {
		try {
			String query = QueryHelper.findQuery("address/getAddress.sql");
			PreparedStatement stmnt = conn.prepareStatement(query);
			
			ResultSet rs = stmnt.executeQuery();
			
			return new Address(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find getAddress query");
		}
		
		return null;
	}

	public int createAddress(Address address) {
		try {
			PreparedStatement stmnt = createAddressStatement(address);

			stmnt.executeUpdate();
			conn.commit();
			
			ResultSet rs = stmnt.getGeneratedKeys();
			rs.next();
			return rs.getInt("aid");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public PreparedStatement createAddressStatement(Address address) {
		String query;
		try {
			query = QueryHelper.findQuery("address/createAddress.sql");
			PreparedStatement stmnt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			stmnt.setInt(1, address.num);
			stmnt.setString(2, address.street);
			stmnt.setString(4, address.country);
			stmnt.setString(5, address.province);
			stmnt.setString(6, address.city);
			stmnt.setString(7, address.postalCode);
			
			if (address.apartmentNumber != null) {
				stmnt.setInt(3, address.apartmentNumber);
			} else {
				stmnt.setNull(3, java.sql.Types.INTEGER);
			}
			
			return stmnt;
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the create Address query");
		} catch (SQLException e) {
			System.out.println("Could not create the address");
		}
		
		return null;
	}
}
