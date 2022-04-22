package com.safetynet.webmicroservice.controller;

import java.net.URI;

import com.safetynet.webmicroservice.webmodel.Fire;
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

	private final static Logger log = LogManager.getLogger(FirestationController.class);
	
	@Autowired
	FirestationService firestationService;

	@PostMapping
	public ResponseEntity<Firestation> postNewFirestation(@RequestBody Firestation firestation) {
		Firestation savedFirestation = firestationService.save(firestation);

		log.info("Firestation succesfully saved");

		return new ResponseEntity<>(savedFirestation, HttpStatus.CREATED);
	}

	@PutMapping(path="/address")
	public ResponseEntity<Firestation> updateFirestationByAddress(@RequestParam(value="address") String address, @RequestBody Firestation firestation) {
		Firestation updatedFirestation =  firestationService.update(firestation);
		//if(updatedFirestation==null) {
			//throw new UserNotFoundException("address: "+ address);
		//}
		log.info("Firestation at "+ address +" succesfully changed");
		return new ResponseEntity<>(updatedFirestation, HttpStatus.CREATED);
	}

	@DeleteMapping(path="/address")
	public ResponseEntity<Firestation> deleteFirestationByAddress(@RequestParam(value="address") String address) {
		Firestation deletedFirestation = firestationService.deleteByAddress(address);
		//if(deletedFirestation==null) {
		//	throw new UserNotFoundException("address: "+ address);
		//}
		log.info("Firestation at "+ address +" succesfully deleted");
		return new ResponseEntity<>(deletedFirestation, HttpStatus.NO_CONTENT);
	}

	@PutMapping(path="/station")
	public ResponseEntity<Firestation> updateFirestationByStation(@RequestBody Firestation firestation, @RequestParam(value="station") String station) {
		Firestation updatedFirestation =  firestationService.update(firestation);
		//if(updatedFirestation==null) {
		//	throw new UserNotFoundException("station: "+ station);
		//}
		log.info("Firestation number "+ station +" succesfully changed");
		return new ResponseEntity<>(updatedFirestation, HttpStatus.CREATED);
	}

	@DeleteMapping(path="/station")
	public ResponseEntity<Firestation> deleteFirestationByStation(@RequestParam(value="station") String station) {
		Firestation deletedFirestation = firestationService.deleteByAddress(station);
		//if(deletedFirestation==null) {
		//	throw new UserNotFoundException("station: "+ station);
		//}
		log.info("Firestation number "+ station +" succesfully deleted");
		return new ResponseEntity<>(deletedFirestation, HttpStatus.NO_CONTENT);
	}
	
}
