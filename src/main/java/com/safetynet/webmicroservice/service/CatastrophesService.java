package com.safetynet.webmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webmicroservice.webdaoimpl.CatastrophesDaoImpl;
import com.safetynet.webmicroservice.webmodel.Fire;
import com.safetynet.webmicroservice.webmodel.Flood;

@Service
public class CatastrophesService {

	@Autowired
	private CatastrophesDaoImpl catastrophesDaoImpl;
	
	public List<Fire> fireAlertService(String address) {
		return catastrophesDaoImpl.fireAlert(address);
	}
	
	public Flood floodAlertService(String station) {
		return catastrophesDaoImpl.floodAlert(station);
	}
}
