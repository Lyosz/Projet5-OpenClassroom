package com.safetynet.webmicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webmicroservice.service.CatastrophesService;
import com.safetynet.webmicroservice.webmodel.Fire;
import com.safetynet.webmicroservice.webmodel.Flood;

@RestController
public class CatastrophesController {

	
	@Autowired
	private CatastrophesService catastrophesService;
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path="/fire?address={address}")
	public List<Fire> getAllPersonAtAddressWhenFire(@PathVariable String address) {
		System.out.println(address);
		return catastrophesService.fireAlertService(address);
	}
	
	@ResponseStatus(value = HttpStatus.OK)
	@GetMapping(path="/flood/stations?stations={station_numbers}")
	public Flood getAllPersonAndAddressWhenFloodByStation(@PathVariable String station_numbers) {
		System.out.println(station_numbers);
		return catastrophesService.floodAlertService(station_numbers);
	}
}