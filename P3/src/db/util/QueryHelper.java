package db.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class QueryHelper {
	public static String findQuery(String name) throws FileNotFoundException {
		QueryHelper q = new QueryHelper();

		return q.getFileWithUtil(name);
	}

	private String getFileWithUtil(String fileName) throws FileNotFoundException {
		StringBuilder result = new StringBuilder();
		ClassLoader classLoader = getClass().getClassLoader();

		String filePath = "";
		try {
			filePath = URLDecoder.decode(classLoader.getResource(fileName).getFile(), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			System.out.println("Queries don't have the right encoding for some reason: " + fileName);
		} catch (Exception e) {
			System.out.println("Could not find file: " + fileName);
		}

		if (filePath == "")	throw new FileNotFoundException();

		File file = new File(filePath);

		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append(" ");
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return result.toString();
	}
	
	public static String readString(ResultSet rs, String colName) {
		try {
			return rs.getString(colName);
		} catch (SQLException e) { }
		return "";
	}

	public static Integer readInt(ResultSet rs, String colName) {
		try {
			return rs.getInt(colName);
		} catch (SQLException e) { }
		return null;
	}

	public static Double readDouble(ResultSet rs, String colName) {
		try {
			return rs.getDouble(colName);
		} catch (SQLException e) { }
		return null;
	}

	public static Date readDate(ResultSet rs, String colName) {
		try {
			return rs.getDate(colName);
		} catch (SQLException e) { }
		return null;
	}

	public static Boolean readBoolean(ResultSet rs, String colName) {
		try {
			return rs.getBoolean(colName);
		} catch (SQLException e) { }
		return null;
	}

	// Test method
	public static void main(String[] args) {
		try {
			System.out.println(QueryHelper.findQuery("users/createUser.sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
