package com.safetynet.webmicroservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Catastrophes {

	@GetMapping(value="/fire?address=<{address}>")
	public String getAllPersonAtAddressWhenFire(@PathVariable String address) {
		
		return null;
	}
	
	@GetMapping(value="/flood/stations?stations=<{a list of station_numbers}>")
	public String getAllPersonAndAddressWhenFloodByStation(@PathVariable String station) {
			
		return null;
	}
}