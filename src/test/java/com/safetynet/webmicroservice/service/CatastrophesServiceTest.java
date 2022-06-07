package com.safetynet.webmicroservice.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webmicroservice.service.CatastrophesService;
import com.safetynet.webmicroservice.webdaoimpl.CatastrophesDaoImpl;
import com.safetynet.webmicroservice.webmodel.Address;
import com.safetynet.webmicroservice.webmodel.Fire;
import com.safetynet.webmicroservice.webmodel.Flood;

@ExtendWith(MockitoExtension.class)
public class CatastrophesServiceTest {
	
	private CatastrophesService catastrophesService;

	//TODO:Find the problem with certain Mock object
	@Mock
	CatastrophesDaoImpl catastrophesDaoImpl;
	
	private Flood flood;
	private Fire fire;
	
	private String addressStr;
	//private String wrongAddress;
	
	private String stations;
	//private String wrongStations;
	
	private String medications1 = "aznol:350mg";
	private String medications2 = "hydrapermazol:100mg";
	
	private String allergies1 = "nillacilan";
	
	private List<Address> addresses;
	
	private List<Fire> fireList;
	
	private List<String> medications;
	private List<String> allergies;
	
	private Address address;
	
	@BeforeEach
	public void load() {
		catastrophesService = new CatastrophesService(catastrophesDaoImpl);
		
		//medications = new String[];
		//medications.add(medications1);
		//medications.add(medications2);
		
		//allergies = String[1];
		//allergies.add(allergies1);
		
	}
	
	/**
	 * Those tests are when it's going normally
	 */
	
	@Test
	public void getFloodTest() {
		
		address = new Address("firstname", "lastname", "phone", 21, "address", medications, 
				allergies);
		
		addresses = new ArrayList<Address>();
		addresses.add(address);
		
		flood = new Flood(addresses);
		
		when(catastrophesDaoImpl.getfloodAlert(stations)).thenReturn(flood);
		
		catastrophesService.floodAlertService(stations);
		
		Assertions.assertTrue(flood.getAddress().contains(address), "The Flood object did'nt contain the address object");
	}
	
	@Test
	public void getFireTest() {
		fire = new Fire(addressStr, stations,"name", "phone", 20, medications,
				allergies);
		
		fireList = new ArrayList<Fire>();
		fireList.add(fire);
		
		when(catastrophesDaoImpl.getfireAlert(addressStr)).thenReturn(fireList);
		
		catastrophesService.fireAlertService(addressStr);
		Assertions.assertTrue(fireList.contains(fire), "The Fire List did'nt contain the fire object");
	}
	
	/**
	 * Those tests are when it's not going normally
	 * TODO:Find possible issues to test
	 */
	
	/**
	 * Don't know which problem still has to think of what
	 */
	
	/*
	@Test
	public void wrongGetFloodTest() {
		flood = new Flood(null);
		
		when(catastrophesDaoImpl.getfloodAlert(wrongStations)).thenReturn(flood);
		
		catastrophesService.floodAlertService(wrongStations);
	}
	*/
	
	/**
	 * Don't know which problem still has to think of what
	 */
	
	/*
	@Test
	public void wrongGetFireTest() {
		fire = new Fire();
		when(catastrophesDaoImpl.getfireAlert(wrongAddress)).thenReturn(fireList);
		catastrophesService.fireAlertService(wrongAddress);
	}
	*/
}
