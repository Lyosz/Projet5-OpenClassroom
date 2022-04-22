package com.safetynet.webmicroservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webmicroservice.service.CatastrophesService;
import com.safetynet.webmicroservice.webmodel.Fire;
import com.safetynet.webmicroservice.webmodel.Flood;

@RestController
public class CatastrophesController {

	private static Logger log = LogManager.getLogger(CatastrophesController.class);
	@Autowired
	private CatastrophesService catastrophesService;

	private List<Fire> fireList;
	private Flood flood;

	@GetMapping(path="/fire")
	public ResponseEntity<List<Fire>> getAllPersonAtAddressWhenFire(@RequestParam(value="address") String address) {
		fireList = catastrophesService.fireAlertService(address);
		log.info("Info of persons at " + address + " correctly got");
		return new ResponseEntity<>(fireList, HttpStatus.OK);
	}

	@GetMapping(path="/flood/stations")
	public ResponseEntity<Flood> getAllPersonAndAddressWhenFloodByStation(@RequestParam(value="stations") String station_numbers) {
		flood = catastrophesService.floodAlertService(station_numbers);
		log.info("Info of persons from a list of stations");
		return new ResponseEntity<>(flood, HttpStatus.OK);
	}
}