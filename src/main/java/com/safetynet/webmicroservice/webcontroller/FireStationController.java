package com.safetynet.webmicroservice.webcontroller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class FireStationController {

	@PostMapping(value="/firestation")
	public String postNewFirestation(String person) {
		return "New Firestation";
		
	}
	@PutMapping(value="/firestation/{id}")
	public String updateFirestation(@PathVariable String id) {
		return "Replacement";
	}
	
	@DeleteMapping(value="/firestation/{id}")
	public String deleteFirestation(@PathVariable String id) {
		return "Firestation deleted";
	}
}
