package db.managers;

import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.models.CreditCard;
import db.models.User;
import db.util.QueryHelper;

public class CreditCardManager extends AModelManager {
	public int createNewReview(CreditCard creditCard, User user) {
		// Only a host can create
		if (!user.isLoggedIn()) {
			return -1;
		}
			
		AddressManager am = new AddressManager();
		PreparedStatement createAddressStmnt = am.createAddressStatement(creditCard.address);
		
		if (createAddressStmnt == null) return -1;
		
		int aid = -1;
		
		try {
			createAddressStmnt.executeQuery();
			ResultSet rs = createAddressStmnt.getGeneratedKeys();
			rs.next();
			aid = rs.getInt("aid");
		} catch (SQLException e1) {
			System.out.println("Something went wrong when trying to create the address.");
		}
		
		if (aid == -1) return -1;
		
		try {
			String createPaymentAccountCommand = QueryHelper.findQuery("creditCard/createPaymentAccount.sql");
			PreparedStatement createPaymentAccountStmnt = conn.prepareStatement(createPaymentAccountCommand, Statement.RETURN_GENERATED_KEYS);

			createPaymentAccountStmnt.setString(1, creditCard.pid);
			createPaymentAccountStmnt.setString(2, creditCard.email);
			createPaymentAccountStmnt.setString(3, creditCard.name);
			
			String createCreditCardCommand = QueryHelper.findQuery("creditCard/createCreditCard.sql");
			PreparedStatement createCreditCardStmnt = conn.prepareStatement(createCreditCardCommand, Statement.RETURN_GENERATED_KEYS);

			createCreditCardStmnt.setString(1, creditCard.pid);
			createCreditCardStmnt.setInt(2, aid);
			createCreditCardStmnt.setDate(2, new java.sql.Date(creditCard.expirationDate.getTime())); // Date CANNOT be null here
			
			createPaymentAccountStmnt.executeQuery();
			createCreditCardStmnt.executeQuery();

			conn.commit();
			
			ResultSet ccRS = createCreditCardStmnt.getGeneratedKeys();
			ccRS.next();
			int pid = ccRS.getInt("pid");
			
			return pid;
		} catch (SQLException e) {
			System.out.println("Create credit card failed");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find createCreditCard query");
		}
		
		return -1;
	}

	public CreditCard getPaymentsByUser(User user) {
		CreditCard result = null;

		try {
			String query = QueryHelper.findQuery("creditCard/getCreditCardByUser.sql");
			PreparedStatement stmnt = conn.prepareStatement(query);
			
			stmnt.setString(1, user.email);

			ResultSet rs = stmnt.executeQuery();
			
			rs.next();
			
			return new CreditCard(rs);
		} catch (SQLException e) {
			System.out.println("Get lodgings by id failed");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("lodgings by lid query file was not found");
			e.printStackTrace();
		}
		
		return result;
	}
}