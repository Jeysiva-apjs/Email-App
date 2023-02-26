package com.siva.model;

import java.util.Random;

public class Email {

	private String firstName;
	private String lastName;
	private Department department;
	private static final String company = "aptean";
	private String password;
	private static final int passwordLength = 8;
	private String alternateEmail;
	private String companyMail;

	public Email(String firstName, String lastName, String department, String alternateEmail) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = Department.valueOf(department.toUpperCase());
		this.alternateEmail = alternateEmail;
		this.password = generatePassword();
		this.companyMail = generateCompanyMail();
	}

	private String generateCompanyMail() {
		return firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + 
						department.name().toLowerCase() + "." + company + "." + "com";
	}

	private String generatePassword() {
		
		char[] localPassword = new char[passwordLength];
		int ransomNum;
		String keys = "abcdefghijklmnopqrstuvqxyz1234567890!@#$%^&*";
		
		for(int i=0; i<localPassword.length; i++) {
			ransomNum = (int) (Math.random() * keys.length());
			localPassword[i] = keys.charAt(ransomNum);	
		}
		return new String(localPassword);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAlternateEmail() {
		return alternateEmail;
	}

	public void setAlternateEmail(String alternateEmail) {
		this.alternateEmail = alternateEmail;
	}

	public String getCompanyMail() {
		return companyMail;
	}

	public void setCompanyMail(String companyMail) {
		this.companyMail = companyMail;
	}

	public static int getPasswordLength() {
		return passwordLength;
	}

}
