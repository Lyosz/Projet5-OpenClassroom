package com.safetynet.webmicroservice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webmicroservice.webmodel.Firestations;

@RestController
public class FireStationController {

	@PostMapping(value="/firestation")
	public String postNewFirestation(@RequestBody Firestations firestation) {
		return "New Firestation";
		
	}
	@PutMapping(value="/firestation/{address}")
	public String updateFirestation(@RequestBody @PathVariable String address) {
		return "Replacement";
	}
	
	@DeleteMapping(value="/firestation/{address}")
	public String deleteFirestation(@PathVariable String address) {
		return "Firestation deleted";
	}
		
	@PutMapping(value="/firestation/{station}")
	public String updateFirestation(@RequestBody @PathVariable int station) {
		return "Replacement";
	}
	
	@DeleteMapping(value="/firestation/{station}")
	public String deleteFirestation(@PathVariable int station) {
		return "Firestation deleted";
	}
	
}
