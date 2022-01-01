package com.safetynet.webmicroservice.webdaoimpl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.util.FileReaderToList;
import com.safetynet.webmicroservice.webmodel.Firestation;
@Service
public class FirestationDaoImpl {

	@Autowired
	DataInMemory data;
	
	//This section will be changed
	List<Firestation> firestations;
	//end of section

	public Firestation getFirestationByAddress(String address){
		for(Firestation firestation : firestations) {
			if (firestation.getAddress().equals(address)) {
		    	return firestation;

	    	}
	    
		}
		return null;
	}
	
	public boolean saveFirestation(Firestation firestation) {
			firestations.add(firestation);
			return true;
		
		
	}
	
	public boolean deleteFirestation(String station) {
		for(Firestation firestationInfo : firestations) {
			if (firestationInfo.getStation().equals(station)) {
				firestations.remove(firestationInfo);
				return true;
	    	}
		
	}
		return false;
		
	}
	
	public List<Firestation> getAllFirestations() {
		FileReaderToList listFromFile = new FileReaderToList();
		List<Firestation> firestations = listFromFile.getFirestationToList();
		return firestations;
	}
	
public boolean updateMedicalRecord(Firestation firestation) {
		String station = firestation.getStation();
		
		for(Firestation firestationInfo : firestations) {
			if (firestationInfo.getStation().equals(station)) {
				firestations.remove(firestationInfo);
				firestations.add(firestation);
				return true;
	    	}
		
	}
		return false;
	}

	@PostConstruct
	private void loadData() {
		firestations = data.getFirestation();
	}
}
