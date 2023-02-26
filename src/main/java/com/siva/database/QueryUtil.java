package com.siva.database;

public class QueryUtil {

	public static String insert() {
		return "INSERT INTO email VALUES(?, ?, ?, ?, ?, ?)";
	}

	public static String update() {
		return "UPDATE email SET password = ? WHERE firstName = ? AND lastName = ?";
	}

	public static String selectAll() {
		return "SELECT * FROM email";
	}

}
