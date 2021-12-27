package com.safetynet.webmicroservice.service;

import java.util.List;

import com.safetynet.webmicroservice.util.FileReaderToList;
import com.safetynet.webmicroservice.webmodel.Firestation;

public class FirestationService {

	public Firestation getFirestationByStation(String station){
		
		FileReaderToList listFromFile = new FileReaderToList();
		List<Firestation> firestations = listFromFile.getFirestationToList();
		for(Firestation firestation : firestations) {
			if (firestation.getStation().equals(station)) {
	    		//personInfo.setFirstName("YoBoy");
		    	System.out.println(firestation);
		    	break;

	    	}
	    	//System.out.println(personInfo);
	    
		}
		return null;
	}
	
	public List<Firestation> saveFirestation(Firestation firestation) {
		return null;
	}
	
	public void deleteFirestation(String station) {

		
	}
}
