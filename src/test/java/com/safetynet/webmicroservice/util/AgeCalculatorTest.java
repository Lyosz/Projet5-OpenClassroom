package com.safetynet.webmicroservice.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class AgeCalculatorTest {


	AgeCalculator ageCalculator = new AgeCalculator();
	@Test
	public void ageCalculator() {
		final long aget = 39;
		final String birthday = "05/07/82";
		long age = ageCalculator.calculator(birthday);
		assertEquals(age, aget);
	}
}
