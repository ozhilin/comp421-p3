package db.managers;

import java.sql.Connection;

import db.JDBCConnectionManager;

public abstract class AModelManager {
	protected Connection conn;
	
	protected AModelManager() {
		try {
			conn = JDBCConnectionManager.getConnection();
		} catch (Exception e) {
			System.out.println("Connection to the database could not be established.");
			e.printStackTrace();
		}
	}
	
	protected AModelManager(Connection conn) {
		this.conn = conn;
	}
}
