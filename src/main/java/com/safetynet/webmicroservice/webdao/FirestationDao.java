package com.safetynet.webmicroservice.webdao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.webmodel.Firestations;
@Component
public interface FirestationDao {

	public List<Firestations>findAll();
    public String findById(int station);
    public String findById(String address);
    public String save(Firestations firestation);
    public String update(Firestations firestation);
	
}
