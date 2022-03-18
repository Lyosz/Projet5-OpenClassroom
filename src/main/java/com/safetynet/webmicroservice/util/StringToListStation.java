package com.safetynet.webmicroservice.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class StringToListStation {

	public List<String> toListStation(String stations) {
		
		List<String> stationToList = new ArrayList<String>();
		boolean t = stations.contains(",");
		
		if(t==true) {
			
			String[] station = stations.split(",");
			for(String station1 : station) {
				stationToList.add(station1);
			}
			return stationToList;
		}
		
		stationToList.add(stations);
		return stationToList;
	}
}
