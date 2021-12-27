package com.safetynet.webmicroservice.util;


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
