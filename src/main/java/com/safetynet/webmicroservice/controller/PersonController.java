package com.safetynet.webmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webmicroservice.webdaoimpl.PersonDaoImpl;
import com.safetynet.webmicroservice.webmodel.Person;
import com.safetynet.webmicroservice.webmodel.Persons;

@RestController
public class PersonController {

	
	@Autowired
	private PersonDaoImpl daoPersonDao;

	//private JsonWriter jsonWriter;
	/**
	 * 
	 * {id} is to find a person more easily by being a combination of {firstname-lastname},
	 * by doing that we avoid a variable id
	 * (through it would be probably better in a real scenario)
	 *
	 */
	@PostMapping(path="/person")
	public Person saveNewPerson(@RequestBody Person person) {
		
		return daoPersonDao.save(person);
	}
	
	@PutMapping(path="/person/{id}")
	public Person updatePerson(@PathVariable String id, @RequestBody Person person) {
		return daoPersonDao.update(person);
	}
	
	@DeleteMapping(path="/person/{id}")
	public boolean deletePerson(@PathVariable String id) {
		return daoPersonDao.delete(id);
	}
	
	@GetMapping(path="/person/{id}")
	public Person getPerson(@PathVariable String id) {
		
		return daoPersonDao.findById(id);
	
	}
	
	@GetMapping(path="/personinfo?firstName=<{firstName}>&lastName=<{lastName}>")
	public String getAllPersoninfo(@PathVariable String firstName,@PathVariable String lastName) {
		
		return null;
				
	
	}
}
