package com.safetynet.webmicroservice.util;


import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;


public class StringToListStationTest {

	StringToListStation stringToListStation = new StringToListStation();
	
	@Test
	public void stationsToList() {
		
		List<String> station = new ArrayList<String>();
		station.add("1");
		station.add("5");
		station.add("6");
		final String stations = "1,5,6";
		List<String> stationTest = stringToListStation.toListStation(stations);
		Assertions.assertEquals(stationTest, station);
	}
	
	@Test
	public void stationToList() {
		
		final List<String> station = new ArrayList<String>();
		station.add("2");
		final String stations = "2";
		List<String> stationTest = stringToListStation.toListStation(stations);
		Assertions.assertEquals(stationTest, station);
	}
}
