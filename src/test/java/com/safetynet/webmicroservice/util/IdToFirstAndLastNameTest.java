package com.safetynet.webmicroservice.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class IdToFirstAndLastNameTest {

	IdToFirstAndLastName idToFirstAndLastName = new IdToFirstAndLastName();
	
	final private String id = "Theodore-Tres";
	
	@Test
	public void idToFirstname() {
		final String firstname = "Theodore";
		String firstnameTest = idToFirstAndLastName.getLastName(id);
		assertEquals(firstname, firstnameTest);
	}
	
	@Test
	public void idToLastname() {
		final String lastname = "Tres";
		String lastnameTest = idToFirstAndLastName.getLastName(id);
		assertEquals(lastname, lastnameTest);
	}
}
