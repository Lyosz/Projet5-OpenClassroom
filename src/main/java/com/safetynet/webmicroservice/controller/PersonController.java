package com.safetynet.webmicroservice.controller;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.safetynet.webmicroservice.service.PersonService;
import com.safetynet.webmicroservice.webmodel.Person;

@RestController
public class PersonController {

	private static Logger log = LogManager.getLogger(PersonController.class);
	
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
	@ResponseStatus(value=HttpStatus.CREATED)
	@PostMapping(path="/person")
	public Person saveNewPerson(@RequestBody Person person) {
		Person savedPerson = personService.save(person);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{firstname}").buildAndExpand(savedPerson.getFirstName()).toUri();
		log.info("Person succesfully saved");
		//return ResponseEntity.created(location).build();
		return savedPerson;
	}
	@ResponseStatus(value=HttpStatus.CREATED)
	@PutMapping(path="/person/{id}")
	public Person updatePerson(@PathVariable String id, @RequestBody Person person) {
		log.info("Person at "+ id +" succesfully changed");
		return personService.update(person);
	}
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping(path="/person/{id}")
	public boolean deletePerson(@PathVariable String id) {
		log.info("Person at "+ id +" succesfully deleted");
		return personService.delete(id);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path="/person/{id}")
	public Person getPerson(@PathVariable String id) {
		log.info("Person at "+ id +" succesfully got");
		return personService.findById(id);
	
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path="/personinfo")
	public Person getAllPersoninfo(@RequestParam(value="firstName", required=false) String firstName, 
								@RequestParam(value="lastName", required=true) String lastName) {
		
		String id = firstName + "-" + lastName;
		log.info("Person with firstname= "+ firstName +" and lastname= "+ lastName +" succesfully got");
		return personService.findById(id);
				
	}
}
