package com.safetynet.webmicroservice.controller;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.safetynet.webmicroservice.service.FirestationService;
import com.safetynet.webmicroservice.webmodel.Firestation;

@RestController
@RequestMapping("/firestation")
public class FirestationController {

	private static Logger log = LogManager.getLogger(FirestationController.class);
	
	@Autowired
	FirestationService firestationService;
	
	@ResponseStatus(value=HttpStatus.CREATED)
	@PostMapping
	public Firestation postNewFirestation(@RequestBody Firestation firestation) {
		Firestation savedFirestation = firestationService.save(firestation);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{address}").buildAndExpand(savedFirestation.getAddress()).toUri();
		//if(savedFirestation==null) {
		//	return (ResponseEntity<Firestation>) ResponseEntity.notFound();
		//}
		log.info("Firestation succesfully saved");
		//return ResponseEntity.created(location).build();	
		return savedFirestation;
	}
	@ResponseStatus(value=HttpStatus.CREATED)
	@PutMapping(path="/address")
	public Firestation updateFirestationByAddress(@RequestParam(value="address") String address, @RequestBody Firestation firestation) {
		Firestation updatedFirestation =  firestationService.update(firestation);
		//if(updatedFirestation==null) {
			//throw new UserNotFoundException("address: "+ address);
		//}
		log.info("Firestation at "+ address +" succesfully changed");
		return updatedFirestation;
	}
	
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping(path="/address")
	public Firestation deleteFirestationByAddress(@RequestParam(value="address") String address) {
		Firestation deletedFirestation = firestationService.deleteByAddress(address);
		//if(deletedFirestation==null) {
		//	throw new UserNotFoundException("address: "+ address);
		//}
		log.info("Firestation at "+ address +" succesfully deleted");
		return deletedFirestation;
	}
	@ResponseStatus(value=HttpStatus.CREATED)	
	@PutMapping(path="/station")
	public Firestation updateFirestationByStation(@RequestBody Firestation firestation, @RequestParam(value="station") String station) {
		Firestation updatedFirestation =  firestationService.update(firestation);
		//if(updatedFirestation==null) {
		//	throw new UserNotFoundException("station: "+ station);
		//}
		log.info("Firestation number "+ station +" succesfully changed");
		return updatedFirestation;
	}
	
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping(path="/station")
	public Firestation deleteFirestationByStation(@RequestParam(value="station") String station) {
		Firestation deletedFirestation = firestationService.deleteByAddress(station);
		//if(deletedFirestation==null) {
		//	throw new UserNotFoundException("station: "+ station);
		//}
		log.info("Firestation number "+ station +" succesfully deleted");
		return deletedFirestation;
	}
	
}
