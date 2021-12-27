package com.safetynet.webmicroservice.webdao;

import java.util.List;

import com.safetynet.webmicroservice.webmodel.Firestations;

public interface FirestationDao {

	public List<Firestations>findAll();
    public String findById(int station);
    public String findById(String address);
    public String save(Firestations firestation);
    public String update(Firestations firestation);
	
}
