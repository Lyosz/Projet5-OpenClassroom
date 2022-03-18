package com.safetynet.webmicroservice.webdaoimpl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.util.IdToFirstAndLastName;
import com.safetynet.webmicroservice.webdao.PersonDao;
import com.safetynet.webmicroservice.webmodel.Person;

@Repository
public class PersonDaoImpl implements PersonDao{
	
	@Autowired
	private DataInMemory data;
	@Autowired
	private IdToFirstAndLastName idFirstAndLastName;
	
	private List<Person> persons;
	private String firstname;
	private String lastname;
	
	PersonDaoImpl(){
		
	}
	
	/**
	 * For test use only
	 * @param personsTest = In memory data for unit testing
	 */
	
	PersonDaoImpl(List<Person> personsTest){
		/**
		 * Don't know how the PostConstruct really operate
		 * If it override data from person = data.getPerson()
		 * then I'll create a new variable and methods
		 * to be of use when testing
		 */
		this.persons = personsTest;
	}
	
	/**
	 * For test use only
	 * @param personsTest = In memory data for unit testing
	 * @param idFirstAndLastName = determine from a id the first and lastname
	 */
	
	PersonDaoImpl(List<Person> personsTest, IdToFirstAndLastName idFirstAndLastNameTest){
		/**
		 * Don't know how the PostConstruct really operate
		 * If it override data from person = data.getPerson()
		 * then I'll create a new variable and methods
		 * to be of use when testing
		 */
		this.persons = personsTest;
		this.idFirstAndLastName = idFirstAndLastNameTest;
	}
	
	/**
	 * Get a Person object from a String @param id
	 * that contains first and lastname
	 */
	
	@Override
	public Person getPersonByNameAndLastname(String id){
		firstname = idFirstAndLastName.getFirstName(id);
		lastname = idFirstAndLastName.getLastName(id);
		for(Person personInfo : persons) {
			if (personInfo.getFirstName().equals(firstname) && personInfo.getLastName().equals(lastname)) {
	    		return personInfo;
	    	}
	    	
	    
		}
		return null;
	}
	
	/**
	 * Save a Person object to database (In memory)
	 * @param person = Person object to save
	 */
	
	@Override
	public Person savePerson(Person person) {
		persons.add(person);
		return person;
	}
	
	/**
	 * Delete a Person object in database (In memory)
	 * by a @param id that contains first and lastname
	 */
	
	@Override
	public boolean deletePerson(String id) {
		firstname = idFirstAndLastName.getFirstName(id);
		lastname = idFirstAndLastName.getLastName(id);
		for(Person personInfo : persons) {
			if (personInfo.getFirstName().equals(firstname) && personInfo.getLastName().equals(lastname)) {
				persons.remove(personInfo);
				return true;
	    	}
		
		}
		return false;
	}
	
	/**
	 * Update a Person object in database (In memory)
	 * @param person = Person object to update, 
	 * it contains first and lastname to indentificate the specific object in database
	 */
	
	@Override
	public Person updatePerson(Person person) {
		
		String firstName = person.getFirstName();
		String lastName = person.getLastName();
		
		for(Person personInfo : persons) {
			if (personInfo.getFirstName().equals(firstName) && personInfo.getLastName().equals(lastName)) {
				persons.remove(personInfo);
				persons.add(person);
				return person;
	    	}
		
	}
		return null;
	}
	
	/**
	 * It is in fact the In memory database
	 */
	
	@PostConstruct
	private void loadData() {
		persons = data.getPerson();
	}

}
