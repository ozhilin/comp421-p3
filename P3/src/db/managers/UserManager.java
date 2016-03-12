package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
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
			
			pstmnt.addBatch();
			pstmnt.executeBatch();
			
			conn.commit();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
