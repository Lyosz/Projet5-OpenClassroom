package com.safetynet.webmicroservice.util;

import org.springframework.stereotype.Component;

@Component
public class IdToFirstAndLastName {

	/**
	 * This class serve to identificate firstname from lastname
	 * through a variable @param id that contains both separated by a specific
	 * char @c 
	 */
	
	private String c = "-";
	/**
	 * Getting firstname by substring the second part of id  
	 * by the char at the last index
	 */
	
	private String[] getFullName(String id) {
		String[] fullname = id.split(c);
		return fullname;
	}
	
	public String getFirstName(String id) {
		

		String[] fullname = getFullName(id);
		String firstname = fullname[0];
		return firstname;
	}
	/**
	 * Getting lastname by substring the first part of id  
	 * by the char as the first index plus one
	 */
	public String getLastName(String id) {
		
		String[] fullname = getFullName(id);
		String lastName = fullname[1];
		return lastName;

	}
}
