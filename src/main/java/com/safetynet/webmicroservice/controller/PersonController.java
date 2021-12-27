package com.safetynet.webmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.safetynet.webmicroservice.webmodel.Persons;

@RestController
public class PersonController {

	
	//@Autowired
	//private Person daoPersonDao;

	//private JsonWriter jsonWriter;
	/**
	 * 
	 * {id} is to find a person more easily by being a combination of {firstname-lastname},
	 * by doing that we avoid a variable id
	 * (through it would be probably better in a real scenario)
	 *
	 */
	@PostMapping(path="/person")
	public String saveNewPerson(@RequestBody Persons person) {
		
		return null;
	}
	
	@PutMapping(path="/person/{id}")
	public String updatePerson(@PathVariable String id, @RequestBody Persons person) {
		return "Replacement";
	}
	
	@DeleteMapping(path="/person/{id}")
	public String deletePerson(@PathVariable String id) {
		return "Person deleted";
	}
	
	@GetMapping(path="/person/{id}")
	public Persons getPerson(@PathVariable String id) {
		
		//jsonWriter.getPersonJson(id);
		return null; //JsonWriter.getPersonJson(id);
				//PersonDao.findPersonById(id);
	
	}
	
	@GetMapping(path="/personinfo?firstName=<{firstName}>&lastName=<{lastName}>")
	public String getAllPersoninfo(@PathVariable String firstName,@PathVariable String lastName) {
		
		return null;
				//PersonDao.findAllPerson();
	
	}
}
