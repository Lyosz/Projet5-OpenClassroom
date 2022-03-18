package com.safetynet.webmicroservice.util;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class AgeCalculatorTest {
	
	AgeCalculator ageCalculator = new AgeCalculator();
	
	@Test
	public void ageCalculator() {
		final long ageTest = 39;
		final String birthday = "05/07/82";
		long age = ageCalculator.calculator(birthday);
		Assertions.assertEquals(age, ageTest);
	}
}
