package db.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
			System.out.println("Could not find file: " + fileName);
			e1.printStackTrace();
		}
		
		if (filePath == "") throw new FileNotFoundException();
		
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
	
	// Test method
	public static void main(String[] args) {
		try {
			System.out.println(QueryHelper.findQuery("users/createUser.sql"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
