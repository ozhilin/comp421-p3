package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import db.models.CreditCard;
import db.models.User;
import db.util.QueryHelper;

public class CreditCardManager extends AModelManager {
	public String createNewCreditCard(CreditCard creditCard, User user) {
		return createNewCreditCard(creditCard, user, true);
	}
	
	public String createNewCreditCard(CreditCard creditCard, User user, boolean shouldCommit) {
		if (!user.isLoggedIn()) {
			return "";
		}
			
		AddressManager am = new AddressManager();

		int aid = -1;
		try (PreparedStatement createAddressStmnt = am.createAddressStatement(creditCard.address)) {
			if (createAddressStmnt == null) return "";
			
			createAddressStmnt.executeUpdate();

			try (ResultSet rs = createAddressStmnt.getGeneratedKeys()) {
				rs.next();
				aid = rs.getInt("aid");
			}
		} catch (SQLException e2) {
			try {
				conn.rollback();
			} catch (SQLException e1) { }
		}

		if (aid == -1) return "";
		
		String createPaymentAccountCommand = "";
		try {
			createPaymentAccountCommand = QueryHelper.findQuery("creditCard/createPaymentAccount.sql");
		} catch (FileNotFoundException e1) {
			return "";
		}
		
		if (createPaymentAccountCommand == "") return "";

		try (PreparedStatement createPaymentAccountStmnt = 
				conn.prepareStatement(createPaymentAccountCommand, Statement.RETURN_GENERATED_KEYS)) {

			createPaymentAccountStmnt.setString(1, creditCard.pid);
			createPaymentAccountStmnt.setString(2, creditCard.email);
			createPaymentAccountStmnt.setString(3, creditCard.name);
			createPaymentAccountStmnt.executeUpdate();
			
			String pid = "";
			try (ResultSet cpRS = createPaymentAccountStmnt.getGeneratedKeys()) {
				cpRS.next();
				pid = cpRS.getString("pid");
			}
			
			String createCreditCardCommand = QueryHelper.findQuery("creditCard/createCreditCard.sql");

			try (PreparedStatement createCreditCardStmnt = 
					conn.prepareStatement(createCreditCardCommand, Statement.RETURN_GENERATED_KEYS)) {
				createCreditCardStmnt.setString(1, creditCard.pid);
				createCreditCardStmnt.setInt(2, aid);

				// Date CANNOT be null here
				createCreditCardStmnt.setDate(3, new java.sql.Date(creditCard.expirationDate.getTime())); 
				
				createCreditCardStmnt.executeUpdate();

				if (shouldCommit) {
					conn.commit();
				}
				
				return pid;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) { }
		} catch (FileNotFoundException e) { }
		
		return "";
	}

	public Map<String, CreditCard> getPaymentsByUser(User user) {
		Map<String, CreditCard> result = new HashMap<String, CreditCard>();

		String query = "";
		try {
			query = QueryHelper.findQuery("creditCard/getCreditCardByUser.sql");
		} catch (FileNotFoundException e1) { 
			return null;
		}
		
		if (query == "") return null;

		try (PreparedStatement stmnt = conn.prepareStatement(query);) {
			stmnt.setString(1, user.email);

			ResultSet rs = stmnt.executeQuery();
			
			while(rs.next()) {
				result.put(rs.getString("pid"), new CreditCard(rs));
			}
		} catch (SQLException e) { 
			return null; 
		} 		

		return result;
	}
}
