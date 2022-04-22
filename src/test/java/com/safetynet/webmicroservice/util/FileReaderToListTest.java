package com.safetynet.webmicroservice.util;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import com.safetynet.webmicroservice.constants.JsonPathConstant;
import com.safetynet.webmicroservice.webmodel.Firestation;
import com.safetynet.webmicroservice.webmodel.Medicalrecord;
import com.safetynet.webmicroservice.webmodel.Person;


public class FileReaderToListTest {

	private FileReaderToList fileReaderToList;
	
	private  List<Firestation> firestationsTest;
	
	private  List<Person> personsTest;
	
	private  List<Medicalrecord> medicalRecordTest;
	
	private ArrayList<String> medications = new ArrayList<String>();
	private ArrayList<String> allergies = new ArrayList<String>();
	
	private Firestation firestation = new Firestation("1509 Culver St","3");
	
	private Person person = new Person("John", "Boyd","1509 Culver St","Culver","97451","841-874-6512", "jaboyd@email.com" );
	
	private Medicalrecord medicalRecord;
	
	private String medications1 = "aznol:350mg";
	private String medications2 = "hydrapermazol:100mg";
	
	private String allergies1 = "nillacilan";
	
	private String JSONPATHTEST = JsonPathConstant.JSONPATHTEST;
	
	@BeforeEach
	public void setup() {
		fileReaderToList = new FileReaderToList(JSONPATHTEST);
		
	}
	
	@Test
	public void firestationToListTest() {
		firestationsTest = fileReaderToList.getFirestationToList();
		//Assertions.assertEquals(firestationsTest, firestationsFalseData);
		Assertions.assertTrue(firestationsTest.contains(firestation));
	}
	
	@Test
	public void personToListTest() {
		
		personsTest = fileReaderToList.getPersonToList();
		//for (Person persons :personsTest) {
		//	if(persons.toString().equals(person.toString())) {
		//		assertEquals(persons.toString(), person.toString());
		//	}
		//}
		//Assertions.assertEquals(personsTest, personFalseData);
		Assertions.assertTrue(personsTest.contains(person));
	}
	
	@Test
	public void medicalRecordToListTest() {
		medications.add(medications1);
		medications.add(medications2);
		allergies.add(allergies1);
		medicalRecord = new Medicalrecord("John", "Boyd","03/06/1984", medications, allergies);
		//medicalRecordFalseData.add(medicalRecord);
		medicalRecordTest = fileReaderToList.getMedicalRecordToList();
		//Assertions.assertEquals(medicalRecordTest, medicalRecordFalseData);
		Assertions.assertTrue(medicalRecordTest.contains(medicalRecord));
	}
}
