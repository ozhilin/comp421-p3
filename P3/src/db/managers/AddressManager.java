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
		String query;
		try {
			query = QueryHelper.findQuery("address/getAddress.sql");
		} catch (FileNotFoundException e) {
			return null;
		}

		try(PreparedStatement stmnt = conn.prepareStatement(query)) {
			try (ResultSet rs = stmnt.executeQuery()) {
				return new Address(rs);
			}
		} catch (SQLException e) {
			return null;
		}
	}

	public int createAddress(Address address) {
		try (PreparedStatement stmnt = createAddressStatement(address)) {
			if (stmnt == null) return -1;
			
			stmnt.executeUpdate();
			conn.commit();
			
			try(ResultSet rs = stmnt.getGeneratedKeys()) {
				rs.next();
				return rs.getInt("aid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public PreparedStatement createAddressStatement(Address address) {
		String query;
		try {
			query = QueryHelper.findQuery("address/createAddress.sql");
		} catch (FileNotFoundException e1) {
			return null;
		}

		PreparedStatement stmnt = null;

		try {
			stmnt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

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
		} catch (SQLException e) { }
		
		return stmnt;
	}
}
