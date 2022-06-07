package com.safetynet.webmicroservice.service;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webmicroservice.service.PersonService;
import com.safetynet.webmicroservice.webdaoimpl.PersonDaoImpl;
import com.safetynet.webmicroservice.webmodel.Person;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	PersonService personService;

	@Mock
	PersonDaoImpl personDaoImpl;

	private String id;
	private String wrongId;
	
	private Person personServiceTest;
	private Person person;
	private Person wrongPerson;
	
	private boolean personServiceTestBolean;
	
	@BeforeEach
	public void load() {
		personService = new PersonService(personDaoImpl);
		person = new Person();
	}
	
	/**
	 * Those tests are when it's going normally
	 */
	
	@Test
	public void savePersonTest() {
		
		when(personDaoImpl.savePerson(person)).thenReturn(person);
		personServiceTest = personService.save(person);
		Assertions.assertEquals(personServiceTest, person, "The object Person isn't identical");
	}
	
	@Test
	public void deletePersonTest() {
		
		when(personDaoImpl.deletePerson(id)).thenReturn(true);
		personServiceTestBolean = personService.delete(id);
		Assertions.assertEquals(personServiceTestBolean, true, "PersonService.delete did'nt return true");
	}
	
	@Test
	public void updatePersonTest() {
		
		when(personDaoImpl.updatePerson(person)).thenReturn(person);
		personServiceTest = personService.update(person);
		Assertions.assertEquals(personServiceTest, person, "The object Person isn't identical");
	}
	
	@Test
	public void getPersonTest() {
		
		when(personDaoImpl.getPersonByNameAndLastname(id)).thenReturn(person);
		personServiceTest = personService.findById(id);
		Assertions.assertEquals(personServiceTest, person, "The object Person isn't identical");
	}

	/**
	 * Those tests are when it's not going normally
	 */
	
	@Test
	public void wrongSavePersonTest() {
		
		when(personDaoImpl.savePerson(wrongPerson)).thenReturn(null);
		personServiceTest = personService.save(wrongPerson);
		Assertions.assertEquals(personServiceTest, null, "PersonService.save did'nt return null");
	}
	
	@Test
	public void wrongDeletePersonTest() {
		
		when(personDaoImpl.deletePerson(wrongId)).thenReturn(false);
		personServiceTestBolean = personService.delete(wrongId);
		Assertions.assertEquals(personServiceTestBolean, false, "PersonService.delete did'nt return false");
	}
	
	@Test
	public void wrongUpdatePersonTest() {
		
		when(personDaoImpl.updatePerson(wrongPerson)).thenReturn(null);
		personServiceTest = personService.update(wrongPerson);
		Assertions.assertEquals(personServiceTest, null, "PersonService.update did'nt return null");
	}
	
	@Test
	public void wrongGetPersonTest() {
		
		when(personDaoImpl.getPersonByNameAndLastname(wrongId)).thenReturn(null);
		personServiceTest = personService.findById(wrongId);
		Assertions.assertEquals(personServiceTest, null, "PersonService.findById did'nt return null");
	}

}
