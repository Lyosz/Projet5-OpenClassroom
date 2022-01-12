package com.safetynet.webmicroservice.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.safetynet.webmicroservice.exception.UserNotFoundException;
import com.safetynet.webmicroservice.service.FirestationService;
import com.safetynet.webmicroservice.webmodel.Firestation;

@RestController
@RequestMapping("/firestation")
public class FirestationController {

	@Autowired
	FirestationService firestationService;
	
	@PostMapping
	public ResponseEntity<Firestation> postNewFirestation(@RequestBody Firestation firestation) {
		Firestation savedFirestation = firestationService.save(firestation);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{address}").buildAndExpand(savedFirestation.getAddress()).toUri();
		return ResponseEntity.created(location).build();	
	}
	
	@PutMapping(value="/{address}")
	public Firestation updateFirestationByAddress(@RequestBody Firestation firestation, @PathVariable String address) {
		Firestation updatedFirestation =  firestationService.update(firestation);
		if(updatedFirestation==null) {
			throw new UserNotFoundException("address: "+ address);
		}
		return firestation;
	}
	
	@DeleteMapping(value="/{address}")
	public void deleteFirestationByAddress(@PathVariable String address) {
		Firestation deletedFirestation = firestationService.deleteByAddress(address);
		if(deletedFirestation==null) {
			throw new UserNotFoundException("address: "+ address);
		}
	}
		
	@PutMapping(value="/{station}")
	public Firestation updateFirestationByStation(@RequestBody Firestation firestation, @PathVariable String station) {
		Firestation updatedFirestation =  firestationService.update(firestation);
		if(updatedFirestation==null) {
			throw new UserNotFoundException("station: "+ station);
		}
		return firestation;
	}
	
	@DeleteMapping(value="/{station}")
	public void deleteFirestationByStation(@PathVariable String station) {
		Firestation deletedFirestation = firestationService.deleteByAddress(station);
		if(deletedFirestation==null) {
			throw new UserNotFoundException("station: "+ station);
		}
	}
	
}
