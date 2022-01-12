package com.safetynet.webmicroservice.webdaoimpl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.webdao.FirestationDao;
import com.safetynet.webmicroservice.webmodel.Firestation;

@Service
public class FirestationDaoImpl implements FirestationDao{

	@Autowired
	DataInMemory data;

	List<Firestation> firestations;

	
	@Override
	public Firestation getFirestationByAddress(String address){
		for(Firestation firestation : firestations) {
			if (firestation.getAddress().equals(address)) {
		    	return firestation;

	    	}
	    
		}
		return null;
	}
	
	@Override
	public Firestation saveFirestation(Firestation firestation) {
			firestations.add(firestation);
			return null;
		
		
	}
	
	@Override
	public void deleteFirestationByStation(String station) {
		for(Firestation firestationInfo : firestations) {
			if (firestationInfo.getStation().equals(station)) {
				firestations.remove(firestationInfo);	
	    	}
		}		
	}
	
	@Override
	public Firestation updateFirestation(Firestation firestation) {
		String station = firestation.getStation();
		
		for(Firestation firestationInfo : firestations) {
			if (firestationInfo.getStation().equals(station)) {
				firestations.remove(firestationInfo);
				firestations.add(firestation);
				return firestation;
	    	}
		
		}
		return null;
	}

	@Override
	public Firestation getFirestationByStation(String station) {
		for(Firestation firestation : firestations) {
			if (firestation.getStation().equals(station)) {
		    	return firestation;

	    	}
	    
		}
		return null;
	}

	@Override
	public void deleteFirestationByAddress(String address) {
		for(Firestation firestationInfo : firestations) {
			if (firestationInfo.getAddress().equals(address)) {
				firestations.remove(firestationInfo);	
	    	}
		}	
		
	}

	@PostConstruct
	private void loadData() {
		firestations = data.getFirestation();
	}
	
}
