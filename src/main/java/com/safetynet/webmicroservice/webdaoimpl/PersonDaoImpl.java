package com.safetynet.webmicroservice.webdaoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.service.PersonService;
import com.safetynet.webmicroservice.util.IdToFirstAndLastName;
import com.safetynet.webmicroservice.webdao.PersonDao;
import com.safetynet.webmicroservice.webmodel.Person;


@Component
public class PersonDaoImpl implements PersonDao{

	@Autowired
	private PersonService personService;
	@Autowired
	IdToFirstAndLastName idFirstAndLastName;
	
	@Override
	public Person findById(String id) {
		String firstname = idFirstAndLastName.getFirstName(id);
		String lastname = idFirstAndLastName.getLastName(id);
		return personService.getPersonByNameAndLastname(firstname, lastname);
	}

	@Override
	public Person save(Person person) {
		
		return personService.savePerson(person);
	}

	@Override
	public Person update(Person person) {
		
		return personService.updatePerson(person);
	}

	@Override
	public boolean delete(String id) {
		String firstname = idFirstAndLastName.getFirstName(id);
		String lastname = idFirstAndLastName.getLastName(id);
		return personService.deletePerson(firstname, lastname);
	}


}
