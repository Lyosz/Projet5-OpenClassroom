package com.safetynet.webmicroservice.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path="/fire")
	public List<Fire> getAllPersonAtAddressWhenFire(@RequestParam(value="address") String address) {
		log.info("Info of persons at " + address + " correctly got");
		return catastrophesService.fireAlertService(address);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path="/flood/stations")
	public Flood getAllPersonAndAddressWhenFloodByStation(@RequestParam(value="stations") String station_numbers) {
		log.info("Info of persons from a list of stations");
		return catastrophesService.floodAlertService(station_numbers);
	}
}