package com.safetynet.webmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.webdaoimpl.FirestationDaoImpl;
import com.safetynet.webmicroservice.webmodel.Firestation;

@Component
public class FirestationService {

	@Autowired
	FirestationDaoImpl firestationDaoImpl;

	public Firestation findByStation(String station) {
		
		return firestationDaoImpl.getFirestationByStation(station);
	}

	public Firestation findByAddress(String address) {
		
		return firestationDaoImpl.getFirestationByAddress(address);
	}


	public Firestation save(Firestation firestation) {
		
		return firestationDaoImpl.saveFirestation(firestation);
	}


	public Firestation update(Firestation firestation) {
		
		return firestationDaoImpl.updateFirestation(firestation);
	}

	public void deleteByAddress(String address) {
		firestationDaoImpl.deleteFirestationByAddress(address);
	}
	
	public void deleteByStation(String station) {
		firestationDaoImpl.deleteFirestationByStation(station);
	}
}
