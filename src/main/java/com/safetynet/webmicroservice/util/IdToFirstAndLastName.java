package com.safetynet.webmicroservice.util;

public class IdToFirstAndLastName {

	private char c = '-';
	
	public String getFirstName(String id) {
		
		for(int i=0; i< id.length(); i++ ) {
			if(id.charAt(i)==c) {
				String firstName = id.substring(0,i);
				return firstName;
			}
		}
		return null;
	}
	
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
