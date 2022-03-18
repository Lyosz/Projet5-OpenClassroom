package com.safetynet.webmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.util.IdToFirstAndLastName;
import com.safetynet.webmicroservice.webdaoimpl.PersonDaoImpl;
import com.safetynet.webmicroservice.webmodel.Person;


@Component
public class PersonService{

	@Autowired
	private PersonDaoImpl personDaoImpl;
	@Autowired
	IdToFirstAndLastName idFirstAndLastName;
	/**
	 * For test use only
	 * @param personDaoImplTest = Mock Dao
	 */
	public PersonService(PersonDaoImpl personDaoImplTest) {
		this.personDaoImpl = personDaoImplTest;
	}

	/**
	 *
	 **/
	public Person findById(String id) {
		return personDaoImpl.getPersonByNameAndLastname(id);
	}

	public Person save(Person person) {
		
		return personDaoImpl.savePerson(person);
	}

	public Person update(Person person) {
		
		return personDaoImpl.updatePerson(person);
	}

	public boolean delete(String id) {
		return personDaoImpl.deletePerson(id);
	}


}
