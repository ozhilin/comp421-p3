package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.models.User;
import db.util.QueryHelper;
import db.util.StringHelper;

public class UserManager extends AModelManager {
	// No need to return the user id here since the user will have to login anyway
	public void createUser(User user) {
		try {
			String insertQuery = QueryHelper.findQuery("users/createUser.sql");
			PreparedStatement pstmnt = conn.prepareStatement(insertQuery);
			
			pstmnt.setString(1, user.email);
			pstmnt.setString(2, user.password);
			pstmnt.setString(3, user.firstName);
			pstmnt.setString(4, user.lastName);
			pstmnt.setBoolean(6, user.isCustomer);
			pstmnt.setBoolean(7, user.isHost);
			
			if (user.birthdate != null) {
				pstmnt.setDate(5, new java.sql.Date(user.birthdate.getTime()));
			} else {
			}
			pstmnt.setNull(5, java.sql.Types.DATE);

			pstmnt.executeUpdate();
			conn.commit();
		} catch (FileNotFoundException e) {
			System.out.println("Create query not found");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public User loginUser(String email, String password) {
		try {
			String query = QueryHelper.findQuery("users/loginUser.sql");
			PreparedStatement pstmnt = conn.prepareStatement(query);
			
			pstmnt.setString(1, email);
			pstmnt.setString(2, password);
			
			ResultSet rs = pstmnt.executeQuery();
			rs.next();
			
			User user = new User(rs);
			return user;
		} catch (FileNotFoundException e) {
			System.out.println("Login query not found");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Create a new user instance and pass it to this method, it will update
	 * all columns with non null values
	 * 
	 * Note, this will update all of the fields but not the email address, 
	 * since that is impossible, given that the email is our user id.
	 * @param user
	 */
	public void updateUser(User user) {
		try {
			String updateQuery = QueryHelper.findQuery("users/updateUser.sql");
			PreparedStatement pstmnt = conn.prepareStatement(updateQuery);
			
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
		} catch (FileNotFoundException e) {
			System.out.println("Update query not found");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
