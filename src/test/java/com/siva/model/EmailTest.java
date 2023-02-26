package com.siva.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmailTest {
	Email newEmployee;
	
	@BeforeEach
	void setUp() {
		String firstName = "Jey";
		String lastName = "Siva";
		String department = "development";
		String alternateMail = "apj.jey@gmail.com";
		newEmployee = new Email(firstName, lastName, department, alternateMail);
	}
	
	@Test
	void should_ReturnValidEmail() {
		assertEquals("jey.siva@development.aptean.com", newEmployee.getCompanyMail());	
	}

	@Test
	void should_ReturnValidPassword() {
		assertEquals(Email.getPasswordLength(), newEmployee.getPassword().length());
	}
}
