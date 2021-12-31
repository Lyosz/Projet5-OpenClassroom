package com.safetynet.webmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.webmodel.Person;
@Service
public class PersonService {
	
	@Autowired
	DataInMemory data;
	
	//This section will be changed
	List<Person> persons = data.listPersons;
	//end of section
	
	public Person getPersonByNameAndLastname(String firstName, String lastName){
	
		for(Person personInfo : persons) {
			if (personInfo.getFirstName().equals(firstName) && personInfo.getLastName().equals(lastName)) {
	    		return personInfo;
	    	}
	    	
	    
		}
		return null;
	}
	
	public Person savePerson(Person person) {
		persons.add(person);
		return person;
	}
	
	public boolean deletePerson(String firstName, String lastName) {
		
		for(Person personInfo : persons) {
			if (personInfo.getFirstName().equals(firstName) && personInfo.getLastName().equals(lastName)) {
				persons.remove(personInfo);
				return true;
	    	}
		
	}
		return false;
}
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
}
