package com.safetynet.webmicroservice.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StringToListStationTest {

	StringToListStation stringToListStation = new StringToListStation();
	
	@Test
	public void stationsToList() {
		
		final String[] station;
		final String stations = "1,5,6";
		String[] stationTest = stringToListStation.toListStation(stations);
		assertEquals(stationTest, station);
	}
	
	@Test
	public void stationToList() {
		
		final String[] station;
		final String stations = "2";
		String[] stationTest = stringToListStation.toListStation(stations);
		assertEquals(stationTest, station);
	}
}
