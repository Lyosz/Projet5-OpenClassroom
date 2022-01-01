package com.safetynet.webmicroservice.util;

import org.springframework.stereotype.Component;

@Component
public class IdToFirstAndLastName {

	/**
	 * This class serve to identificate firstname from lastname
	 * through a variable @param id that contains both separated by a specific
	 * char @c 
	 */
	
	private char c = '-';
	/**
	 * Getting firstname by substring the second part of id  
	 * by the char at the last index
	 */
	public String getFirstName(String id) {
		
		for(int i=0; i< id.length(); i++ ) {
			if(id.charAt(i)==c) {
				String firstName = id.substring(0,i);
				return firstName;
			}
		}
		return null;
	}
	/**
	 * Getting lastname by substring the first part of id  
	 * by the char as the first index plus one
	 */
	public String getLastName(String id) {
		
		for(int i=0; i< id.length(); i++ ) {
			if(id.charAt(i)==c) {
				String lastName = id.substring(i+1);
				return lastName;
			}
		}
			
		return null;
	}
}
