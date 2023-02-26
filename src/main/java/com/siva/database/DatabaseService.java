package com.siva.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.siva.model.Email;

public class DatabaseService {

	public void insertMail(Email email) throws SQLException {
		
		try(Connection connection = ConnectionPool.getConnection(); 
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.insert())){
			
			preparedStatement.setString(1, email.getFirstName());
			preparedStatement.setString(2, email.getLastName());
			preparedStatement.setString(3, email.getDepartment().name());
			preparedStatement.setString(4, email.getCompanyMail());
			preparedStatement.setString(5, email.getPassword());
			preparedStatement.setString(6, email.getAlternateEmail());
			
			int result = preparedStatement.executeUpdate();
			if(result == 1) {
				System.out.println("Email successfully created");
			}else {
				System.out.println("Something went wrong");
			}
		}
		
	}

	public void changePassword(String fName, String lName, String password) throws SQLException {
		
		try(Connection connection = ConnectionPool.getConnection(); 
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.update())){
			
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, fName);
			preparedStatement.setString(3, lName);
			
			int result = preparedStatement.executeUpdate();
			if(result == 1) {
				System.out.println("password successfully updated");
			}else {
				System.out.println("Something went wrong");
			}
		}
		
	}

	public void printAllEmployee() throws SQLException {
		try(Connection connection = ConnectionPool.getConnection(); 
				PreparedStatement preparedStatement = connection.prepareStatement(QueryUtil.selectAll())){
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				System.out.println();
				System.out.println("First Name: " + resultSet.getString(1));
				System.out.println("Last Name: " + resultSet.getString(2));
				System.out.println("Department: " + resultSet.getString(3));
				System.out.println("Company Email: " + resultSet.getString(4));
				System.out.println("Password: " + resultSet.getString(5));
				System.out.println("Alternate Email: " + resultSet.getString(6));
		}
		
	}
		
	}

}
