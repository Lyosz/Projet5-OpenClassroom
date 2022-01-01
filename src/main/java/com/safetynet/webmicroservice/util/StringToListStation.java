package com.safetynet.webmicroservice.util;

import org.springframework.stereotype.Component;

@Component
public class StringToListStation {

	public String[] toListStation(String stations) {
		
		boolean t = stations.contains(",");
		if(t==true) {
			String[] station = stations.split(",");
			return station;
		}
		

		return null;
	}
}
