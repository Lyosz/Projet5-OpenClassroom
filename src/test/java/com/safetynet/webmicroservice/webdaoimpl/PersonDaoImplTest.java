package com.safetynet.webmicroservice.webdaoimpl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.util.IdToFirstAndLastName;
import com.safetynet.webmicroservice.webmodel.Person;

@ExtendWith(MockitoExtension.class)
public class PersonDaoImplTest {	
	
	private PersonDaoImpl personDao;
	
	private Person person = new Person("Mathieu", "Albatros", "13 rue des Villespintes", "ToncardLand" , "75050", "03451231566",
			"Yo@laposte.net");
	private Person personFromData1 = new Person("Albert", "Albatros", "13 rue des Villespintes", "ToncardLand" , "75050", "065465116354",
			"Yo@laposte.net");
	private Person personFromData2 = new Person("Phillibert", "6e du nom", "Avenue des Roussignols", "Rouge-Gorge" , "14220", "05684132064",
			"Yo@laposte.net");
	private Person personFromData1ToUpdate = new Person("Albert", "Albatros", "14 rue des Villespintes", "Yop" , "04275", "42850346",
			"Yo@laposte.net");
	
	private List<Person> personsFromFalseData;
	private List<Person> persons;
	
	private Person personId;
	private String id = "Albert-Albatros";
	
	@Mock
	private DataInMemory data;
	
	@Mock
	private IdToFirstAndLastName idToFirstAndLastName;
	
	@BeforeEach
	public void load() {
		personsFromFalseData = new ArrayList<Person>();
		personsFromFalseData.add(personFromData1);
		personsFromFalseData.add(personFromData2);
		
		when(data.getPerson()).thenReturn(personsFromFalseData);
		
		persons = data.getPerson();
	}
	
	/**
	 * The program is going smoothly
	 */
	
	@Test
	public void savePersonTest() {
		
		personDao = new PersonDaoImpl(persons);
		personDao.savePerson(person);
		
		Assertions.assertTrue(persons.contains(person), "The Person object did'nt get saved");
	}
	
	@Test
	public void deletePersonTest() {

		when(idToFirstAndLastName.getFirstName(id)).thenReturn("Albert");
		when(idToFirstAndLastName.getLastName(id)).thenReturn("Albatros");
		
		personDao = new PersonDaoImpl(persons, idToFirstAndLastName);
		personDao.deletePerson(id);
		Assertions.assertFalse(persons.contains(person));
	}
	
	
	
	@Test
	public void updatePersonTest() {
		
		personDao = new PersonDaoImpl(persons);
		personDao.updatePerson(personFromData1ToUpdate);
		Assertions.assertTrue(persons.contains(personFromData1ToUpdate));
	}
	
	@Test
	public void getPersonTest() {

		when(idToFirstAndLastName.getFirstName(id)).thenReturn("Albert");
		when(idToFirstAndLastName.getLastName(id)).thenReturn("Albatros");

		personDao = new PersonDaoImpl(persons, idToFirstAndLastName);
		personId = personDao.getPersonByNameAndLastname(id);
		Assertions.assertTrue(personId.equals(personFromData1));
		
	}
	
	/**
	 * The program is'nt going smoothly
	 */
	
	/**
	 * Unknown problem (Can't say in which case)
	 */
	
	/*
	@Test
	public void wrongSavePersonTest() {
		
		person = new Person();
		
		personDao = new PersonDaoImpl(persons);
		personDao.savePerson(person);
		
		Assertions.assertTrue(persons.contains(person), "The Person object did'nt get saved");
	}
	*/
	
	/*
	@Test
	public void wrongDeletePersonTest() {

		id = "Yohan-Renard";
		
		when(idToFirstAndLastName.getFirstName(id)).thenReturn("Yohan");
		when(idToFirstAndLastName.getLastName(id)).thenReturn("Renard");

		personDao = new PersonDaoImpl(persons, idToFirstAndLastName);
		personDao.deletePerson(id);
		Assertions.assertFalse(persons.contains(person));
	}
	
	
	*/
	
	/*
	@Test
	public void wrongUpdatePersonTest() {

		personDao = new PersonDaoImpl(persons);
		personDao.updatePerson(personFromData1ToUpdate);
		Assertions.assertTrue(persons.contains(personFromData1ToUpdate));
	}
	*/
	
	@Test
	public void wrongNotInDatabaseGetPersonTest() {

		id = "Yohan-Renard";
		
		when(idToFirstAndLastName.getFirstName(id)).thenReturn("Yohan");
		when(idToFirstAndLastName.getLastName(id)).thenReturn("Renard");
		
		personDao = new PersonDaoImpl(persons, idToFirstAndLastName);
		personId = personDao.getPersonByNameAndLastname(id);
		Assertions.assertEquals(personId, null);
		
	}
}
