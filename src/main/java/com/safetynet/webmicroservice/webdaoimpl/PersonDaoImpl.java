package com.safetynet.webmicroservice.webdaoimpl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.util.IdToFirstAndLastName;
import com.safetynet.webmicroservice.webdao.PersonDao;
import com.safetynet.webmicroservice.webmodel.Person;
@Service
public class PersonDaoImpl implements PersonDao{
	
	@Autowired
	DataInMemory data;
	@Autowired
	IdToFirstAndLastName idFirstAndLastName;
	
	List<Person> persons;
	String firstname;
	String lastname;
	
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
	
	public Person savePerson(Person person) {
		persons.add(person);
		return person;
	}
	
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
	
	@PostConstruct
	private void loadData() {
		persons = data.getPerson();
	}

}
