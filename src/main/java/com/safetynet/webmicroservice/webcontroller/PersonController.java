package com.safetynet.webmicroservice.webcontroller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	@PostMapping(value="/person")
	public String postNewPerson(String person) {
		return "New Person";
	}
	
	@PutMapping(value="/person/{id}")
	public String updatePerson(@PathVariable String id) {
		return "Replacement";
	}
	
	@DeleteMapping(value="/person/{id}")
	public String deletePerson(@PathVariable String id) {
		return "Person deleted";
	}
}
