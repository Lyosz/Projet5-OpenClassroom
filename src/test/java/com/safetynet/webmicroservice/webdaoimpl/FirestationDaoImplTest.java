package com.safetynet.webmicroservice.webdaoimpl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.util.StringToListStation;
import com.safetynet.webmicroservice.webmodel.Firestation;

@ExtendWith(MockitoExtension.class)
public class FirestationDaoImplTest {

	private FirestationDaoImpl firestationDao;
	
	private Firestation firestation;
	private Firestation firestationToSave = new Firestation("Villepintes", "7");
	private Firestation firestationToUpdate = new Firestation("1509 Culver St", "4");
	private Firestation firestationRawDataFromDao1 = new Firestation("1509 Culver St", "3");
	private Firestation firestationRawDataFromDao2 = new Firestation("Coridor 2", "1");
	
	private List<Firestation> firestations;
	private List<Firestation> firestationFromFalseData;
	
	private String address = "1509 Culver St";
	private String station = "3";
	
	@Mock
	private DataInMemory data;
	
	@Mock
	private StringToListStation stationToList;
	
	
	@BeforeEach
	public void load() {

		firestationFromFalseData = new ArrayList<Firestation>();
		firestationFromFalseData.add(firestationRawDataFromDao1);
		firestationFromFalseData.add(firestationRawDataFromDao2);
	}
	
	@Test
	public void findByAddress(){
		
		when(data.getFirestation()).thenReturn(firestationFromFalseData);
		
		firestations = data.getFirestation();
		
		firestationDao = new FirestationDaoImpl(firestations);
		firestation = firestationDao.getFirestationByAddress(address);
		
		Assertions.assertTrue(firestation.equals(firestationRawDataFromDao1));
	}
	
	@Test
	public void findByStation(){
		
		when(data.getFirestation()).thenReturn(firestationFromFalseData);
		
		firestations = data.getFirestation();
		
		firestationDao = new FirestationDaoImpl(firestations);
		firestation = firestationDao.getFirestationByStation(station);
		
		Assertions.assertTrue(firestation.equals(firestationRawDataFromDao1));
	}
	
	@Test
	public void save() {
		
		when(data.getFirestation()).thenReturn(firestationFromFalseData);
		
		firestations = data.getFirestation();
		
		firestationDao = new FirestationDaoImpl(firestations);
		firestationDao.saveFirestation(firestationToSave);
		
		Assertions.assertTrue(firestations.contains(firestationToSave));
	}
	
	@Test
	public void deleteByAddress() {

		when(data.getFirestation()).thenReturn(firestationFromFalseData);
		
		firestations = data.getFirestation();
		
		firestationDao = new FirestationDaoImpl(firestations);
		firestationDao.deleteFirestationByAddress(address);
		
		Assertions.assertFalse(firestations.contains(firestationRawDataFromDao1));
	}
	
	@Test
	public void deleteByStation() {

		when(data.getFirestation()).thenReturn(firestationFromFalseData);
		
		firestations = data.getFirestation();
		
		firestationDao = new FirestationDaoImpl(firestations);
		firestationDao.deleteFirestationByStation(station);
		
		Assertions.assertFalse(firestations.contains(firestationRawDataFromDao1));
	}
	@Test
	public void update() {

		when(data.getFirestation()).thenReturn(firestationFromFalseData);
		
		firestations = data.getFirestation();
		
		firestationDao = new FirestationDaoImpl(firestations);
		firestationDao.updateFirestation(firestationToUpdate);
		
		Assertions.assertTrue(firestations.contains(firestationToUpdate));
		Assertions.assertFalse(firestations.contains(firestationRawDataFromDao1));
	}
	
}
