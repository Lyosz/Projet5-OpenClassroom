package com.safetynet.webmicroservice.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webmicroservice.service.FirestationService;
import com.safetynet.webmicroservice.webdaoimpl.FirestationDaoImpl;
import com.safetynet.webmicroservice.webmodel.Firestation;

@ExtendWith(MockitoExtension.class)
public class FirestationServiceTest {

	
	private Firestation firestation;
	private Firestation newFirestation;
	private Firestation wrongFirestation;
	
	private FirestationService firestationService;

	@Mock
	private FirestationDaoImpl firestationDaoImpl;
	
	private String address;
	private String station;
	
	private String wrongAddress;
	private String wrongStation;
	
	private Firestation firestationServiceTest;
	@BeforeEach
	public void load() {
		firestationService = new FirestationService(firestationDaoImpl);
		firestation = new Firestation();
		
	}
	
	/**
	 * Those tests are when it's going normally
	 */
	
	@Test
	public void saveFirestationTest() {
		when(firestationDaoImpl.saveFirestation(firestation)).thenReturn(firestation);
		firestationServiceTest = firestationService.save(firestation);
		Assertions.assertEquals(firestationServiceTest, firestation,"The Firestation object is'nt indentical");
	}
	
	@Test
	public void deleteFirestationByAddressTest() {
		when(firestationDaoImpl.deleteFirestationByAddress(address)).thenReturn(null);
		firestationServiceTest = firestationService.deleteByAddress(address);
		Assertions.assertEquals(firestationServiceTest, null, "firestationService.deleteByAddress did'nt return null");
	}
	
	@Test
	public void deleteFirestationByStationTest() {
		when(firestationDaoImpl.deleteFirestationByStation(station)).thenReturn(null);
		firestationServiceTest = firestationService.deleteByStation(station);
		Assertions.assertEquals(firestationServiceTest, null, "firestationService.deleteByStation did'nt return null");
	}
	
	@Test
	public void updateFirestationTest() {
		when(firestationDaoImpl.updateFirestation(newFirestation)).thenReturn(newFirestation);
		firestationServiceTest = firestationService.update(newFirestation);
		Assertions.assertEquals(firestationServiceTest, newFirestation,"The Firestation object is'nt indentical");
	}
	
	@Test
	public void getFirestationByAddressTest() {
		when(firestationDaoImpl.getFirestationByAddress(address)).thenReturn(firestation);
		firestationServiceTest = firestationService.findByAddress(address);
		Assertions.assertEquals(firestationServiceTest, firestation,"The Firestation object is'nt indentical");
	}
	
	@Test
	public void getFirestationByStationTest() {
		when(firestationDaoImpl.getFirestationByStation(station)).thenReturn(firestation);
		firestationServiceTest = firestationService.findByStation(station);
		Assertions.assertEquals(firestationServiceTest, firestation,"The Firestation object is'nt indentical");
	}
	
	/**
	 * Those tests are when it's not going normally
	 */
	
	/**
	 * TODO:Send concrete message/info that indicates it's not working, especially when deleting
	 * TODO: Add wrong uses of the different methods
	 */
	
	@Test
	public void wrongSaveFirestationTest() {
		when(firestationDaoImpl.saveFirestation(wrongFirestation)).thenReturn(null);
		firestationServiceTest = firestationService.save(wrongFirestation);
		Assertions.assertEquals(firestationServiceTest, null,"The firestationService.save did'nt return null");
	}
	
	@Test
	public void wrongDeleteFirestationByAddressTest() {
		when(firestationDaoImpl.deleteFirestationByAddress(wrongAddress)).thenReturn(null);
		firestationServiceTest = firestationService.deleteByAddress(wrongAddress);
		Assertions.assertEquals(firestationServiceTest, null,"The firestationService.deleteByAddress did'nt return null");
	}
	
	@Test
	public void wrongDeleteFirestationByStationTest() {
		when(firestationDaoImpl.deleteFirestationByStation(wrongStation)).thenReturn(null);
		firestationServiceTest = firestationService.deleteByStation(wrongStation);
		Assertions.assertEquals(firestationServiceTest, null,"The firestationService.deleteByStation did'nt return null");
	}
	
	@Test
	public void updateWrongFirestationTest() {
		when(firestationDaoImpl.updateFirestation(wrongFirestation)).thenReturn(null);
		firestationServiceTest = firestationService.update(wrongFirestation);
		Assertions.assertEquals(firestationServiceTest, null,"The firestationService.update did'nt return null");
	}
	
	@Test
	public void getFirestationByWrongAddressTest() {
		when(firestationDaoImpl.getFirestationByAddress(wrongAddress)).thenReturn(null);
		firestationServiceTest = firestationService.findByAddress(wrongAddress);
		Assertions.assertEquals(firestationServiceTest, null,"The firestationService.findByAddress did'nt return null");
	}
	
	@Test
	public void getFirestationByWrongStationTest() {
		when(firestationDaoImpl.getFirestationByStation(wrongStation)).thenReturn(null);
		firestationServiceTest = firestationService.findByStation(wrongStation);
		Assertions.assertEquals(firestationServiceTest, null,"The firestationService.findByStation did'nt return null");
	}
}
