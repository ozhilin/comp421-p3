package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.models.User;
import db.util.QueryHelper;

public class UserManager extends AModelManager {

	/**
	 * No need to return the user id here since the user will have to login anyway
	 * @param user
	 */
	public void createUser(User user) {
		String insertQuery = "";
		try {
			insertQuery = QueryHelper.findQuery("users/createUser.sql");
		} catch (FileNotFoundException e) {
			return;
		}
		
		if (insertQuery == "") return;

		try (PreparedStatement pstmnt = conn.prepareStatement(insertQuery);) {
			pstmnt.setString(1, user.email);
			pstmnt.setString(2, user.password);
			pstmnt.setString(3, user.firstName);
			pstmnt.setString(4, user.lastName);
			pstmnt.setBoolean(6, user.isCustomer);
			pstmnt.setBoolean(7, user.isHost);
			
			if (user.birthdate != null) {
				pstmnt.setDate(5, new java.sql.Date(user.birthdate.getTime()));
			} else {
				pstmnt.setNull(5, java.sql.Types.DATE);
			}

			pstmnt.executeUpdate();
			conn.commit();
		} catch (SQLException e) { }
	}
	
	public User loginUser(String email, String password) {
		String query = "";
		try {
			query = QueryHelper.findQuery("users/loginUser.sql");
		} catch (FileNotFoundException e) {
			return null;
		}
		
		if (query == "") return null;

		try (PreparedStatement pstmnt = conn.prepareStatement(query);) {
			pstmnt.setString(1, email);
			pstmnt.setString(2, password);
			
			try (ResultSet rs = pstmnt.executeQuery()) {
				rs.next();
				return new User(rs);
			}
		} catch (SQLException e) { }
		
		return null;
	}

	public void updateUser(User user) {
		String updateQuery = "";
		try {
			updateQuery = QueryHelper.findQuery("users/updateUser.sql");
		} catch (FileNotFoundException e1) {
			return;
		}
		
		if (updateQuery == "") {
			return;
		}
		
		try (PreparedStatement pstmnt = conn.prepareStatement(updateQuery);) {
			pstmnt.setString(1, user.firstName);
			pstmnt.setString(2, user.lastName);
			pstmnt.setBoolean(4, user.isCustomer);
			pstmnt.setBoolean(5, user.isHost);
			pstmnt.setString(6, user.email);
			
			if (user.birthdate != null) {
				pstmnt.setDate(3, new java.sql.Date(user.birthdate.getTime()));
			} else {
				pstmnt.setNull(3, java.sql.Types.DATE);
			}
			
			pstmnt.executeUpdate();
			conn.commit();
		} catch (SQLException e) { }
	}
}
