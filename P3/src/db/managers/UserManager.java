package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.models.User;
import db.util.QueryHelper;

public class UserManager extends AModelManager {
	public void createUser(User user) {
		try {
			String insertQuery = QueryHelper.findQuery("users/createUser.sql");
			PreparedStatement pstmnt = conn.prepareStatement(insertQuery);
			
			pstmnt.setString(1, user.email);
			pstmnt.setString(2, user.password);
			pstmnt.setString(3, user.firstName);
			pstmnt.setString(4, user.lastName);
			pstmnt.setDate(5, user.birthdate);
			pstmnt.setBoolean(6, user.isCustomer);
			pstmnt.setBoolean(7, user.isHost);
			
			pstmnt.executeUpdate();
			
			conn.commit();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			
			// Password not retrieved
			User user = new User();
			user.email = rs.getString("email");
			user.firstName = rs.getString("fname");
			user.lastName = rs.getString("lname");
			user.birthdate = rs.getDate("birthday");
			user.isCustomer = rs.getBoolean("is_customer");
			user.isHost = rs.getBoolean("is_host");
			
			return user;
		} catch (FileNotFoundException e) {
			System.out.println("Login failed");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
