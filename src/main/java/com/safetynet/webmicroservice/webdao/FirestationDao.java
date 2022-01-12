package com.safetynet.webmicroservice.webdao;

import org.springframework.stereotype.Component;
import com.safetynet.webmicroservice.webmodel.Firestation;

@Component
public interface FirestationDao {

    public Firestation getFirestationByStation(String station);
    public Firestation getFirestationByAddress(String address);
    public Firestation saveFirestation(Firestation firestation);
    public Firestation updateFirestation(Firestation firestation);
    public void deleteFirestationByAddress(String address);
	public void deleteFirestationByStation(String station);
	
}
