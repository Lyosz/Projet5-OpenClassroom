package com.safetynet.webmicroservice.webmodel;

import java.util.List;

public class Firestations {

	private List<Firestation> firestations;

	public Firestations(List<Firestation> firestation) {
		this.firestations = firestation;
	}
	public List<Firestation> getFirestation() {
		return firestations;
	}

	
}
