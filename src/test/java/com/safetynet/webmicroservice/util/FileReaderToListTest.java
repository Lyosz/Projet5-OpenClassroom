package com.safetynet.webmicroservice.util;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.safetynet.webmicroservice.webmodel.Firestation;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.Person;

@SpringBootTest
public class FileReaderToListTest {

	private FileReaderToList fileReaderToList = new FileReaderToList();;
	
	
	@Test
	public void firestationToListTest() {
		final List<Firestation> firestations = null;
		final List<Firestation> firestationsTest = fileReaderToList.getFirestationToListTest();
		assertEquals(firestationsTest, firestations);
	}
	
	@Test
	public void personToListTest() {
		Person person = new Person("John", "Boyd","1509 Culver St","Culver","97451","841-874-6512", "jaboyd@email.com" );
		final List<Person> personsTest = fileReaderToList.getPersonToListTest();
		for (Person persons :personsTest) {
			if(persons.toString().equals(person.toString())) {
				assertEquals(persons.toString(), person.toString());
			}
		}
		assertEquals(personsTest, person);
	}
	
	@Test
	public void medicalRecordToListTest() {
		final List<MedicalRecord> medicalRecord = null;
		final List<MedicalRecord> medicalRecordTest = fileReaderToList.getMedicalRecordToListTest();
		assertEquals(medicalRecordTest, medicalRecord);
	}
}
