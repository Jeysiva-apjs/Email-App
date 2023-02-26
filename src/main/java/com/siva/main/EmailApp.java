package com.siva.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.siva.database.DatabaseService;
import com.siva.model.Email;

public class EmailApp {

	public static void main(String[] args) {

		DatabaseService databaseService = new DatabaseService();

		try (Scanner scan = new Scanner(System.in)) {

			boolean isRunning = true;
			while (isRunning) {

				System.out.println("\nEnter Choice: ");
				System.out.println("1. Generate email");
				System.out.println("2. Change Password");
				System.out.println("3. Get all employee details");
				System.out.println("4. Exit");

				int choice = scan.nextInt();
				scan.nextLine();

				try {
					switch (choice) {
					case 1:
						System.out.println("Enter employee details to genenrate mail: ");
						System.out.println("First Name: ");
						String firstName = scan.nextLine();
						System.out.println("Last Name: ");
						String lastName = scan.nextLine();
						System.out.println("Department(SALES/ DEVELOPMENT/ ACCOUNTING): ");
						String department = scan.nextLine();
						System.out.println("Alternate Email: ");
						String email = scan.nextLine();

						databaseService.insertMail(new Email(firstName, lastName, department, email));
						break;
					case 2:
						System.out.println("Enter following details to change password: ");
						System.out.println("First Name: ");
						String fName = scan.nextLine();
						System.out.println("Last Name: ");
						String lName = scan.nextLine();
						System.out.println("Password: ");
						String password = scan.nextLine();

						databaseService.changePassword(fName, lName, password);
						break;

					case 3:
						databaseService.printAllEmployee();
						break;
					case 4:
						isRunning = false;
						break;
					default:
						System.out.println("nter Correct Option");
						break;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

}
