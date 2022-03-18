package com.safetynet.webmicroservice.util;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

public class IdToFirstAndLastNameTest {

	private IdToFirstAndLastName idToFirstAndLastName = new IdToFirstAndLastName();
	private String id;
	
	/*
	 * BeforeEach and BeforeAll doesn't work.
	 * Don't know why, how.
	 * 
	 */
	
	//@BeforeEach
	//public void setup() {
	//	idToFirstAndLastName = new IdToFirstAndLastName();
	//	id = "Theodore-Tres";
	//}
	
	@Test
	public void idToFirstname() {
		id = "Theodore-Tres";
		final String firstname = "Theodore";
		String firstnameTest = idToFirstAndLastName.getFirstName(id);
		Assertions.assertEquals(firstname, firstnameTest);
	}
	
	@Test
	public void idToLastname() {
		id = "Theodore-Tres";
		final String lastname = "Tres";
		String lastnameTest = idToFirstAndLastName.getLastName(id);
		Assertions.assertEquals(lastname, lastnameTest);
	}
}
