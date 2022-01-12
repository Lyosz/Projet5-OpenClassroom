package com.safetynet.webmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webmicroservice.service.PersonService;
import com.safetynet.webmicroservice.webmodel.Person;

@RestController
public class PersonController {

	
	@Autowired
	private PersonService personService;

	//private JsonWriter jsonWriter;
	/**
	 * 
	 * {id} is to find a person more easily by being a combination of {firstname-lastname},
	 * by doing that we avoid a variable id
	 * (through it would be probably better in a real scenario)
	 *
	 */
	@PostMapping(path="/person")
	public  Person saveNewPerson(@RequestBody Person person) {
		
		return personService.save(person);
	}
	
	@PutMapping(path="/person/{id}")
	public Person updatePerson(@PathVariable String id, @RequestBody Person person) {
		return personService.update(person);
	}
	
	@DeleteMapping(path="/person/{id}")
	public boolean deletePerson(@PathVariable String id) {
		return personService.delete(id);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path="/person/<{id}>")
	public Person getPerson(@PathVariable String id) {
		System.out.println(id);
		return personService.findById(id);
	
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path="/personinfo?firstName=<{firstName}>&lastName=<{lastName}>")
	public String getAllPersoninfo(@PathVariable String firstName,@PathVariable String lastName) {
		
		return null;
				
	}
}
