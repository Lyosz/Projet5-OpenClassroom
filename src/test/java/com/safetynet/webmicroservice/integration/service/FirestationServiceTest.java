package com.safetynet.webmicroservice.integration.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.webmicroservice.service.FirestationService;
import com.safetynet.webmicroservice.webmodel.Firestation;

@SpringBootTest
public class FirestationServiceTest {

	@Autowired
	FirestationService firestationService;
	
	Firestation firestation = new Firestation();
	String address;
	String station;
	
	@Test
	public void saveFirestationTest() {
		firestationService.save(firestation);
	}
	
	@Test
	public void deleteFirestationByAddressTest() {
		firestationService.deleteByAddress(address);
	}
	
	@Test
	public void deleteFirestationByStationTest() {
		firestationService.deleteByStation(station);
	}
	
	@Test
	public void updateFirestationTest() {
		firestationService.update(firestation);
	}
	
	@Test
	public void getFirestationByAddressTest() {
		firestationService.findByAddress(address);
	}
	
	@Test
	public void getFirestationByStationTest() {
		firestationService.findByStation(station);
	}
}
