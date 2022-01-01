package com.safetynet.webmicroservice.util;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.safetynet.webmicroservice.constants.JsonPathConstant;
import com.safetynet.webmicroservice.webmodel.Firestation;
import com.safetynet.webmicroservice.webmodel.Firestations;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.MedicalRecords;
import com.safetynet.webmicroservice.webmodel.Person;
import com.safetynet.webmicroservice.webmodel.Persons;
@Component
public class FileReaderToList {

	public List<MedicalRecord> getMedicalRecordToList() {
	try {
	    // create Gson instance
	    Gson gson = new Gson();

	    // create a reader
	    Reader reader = Files.newBufferedReader(Paths.get(JsonPathConstant.JSONPATH));

	    MedicalRecords medicalRecords = gson.fromJson(reader, MedicalRecords.class);
	    List<MedicalRecord> medicalRecord = medicalRecords.getMedicalRecords();
	    
	    // close reader
	    reader.close();
	    
	    return medicalRecord;
	    
	    
	    
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return null;
}
	
	public List<Firestation> getFirestationToList() {
		try {
		    // create Gson instance
		    Gson gson = new Gson();

		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get(JsonPathConstant.JSONPATH));

		    Firestations firestations = gson.fromJson(reader, Firestations.class);
		    List<Firestation> firestation = firestations.getFirestation();
		    
		    // close reader
		    reader.close();
		    
		    return firestation;
		    
		    
		    
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	
	public List<Person> getPersonToList() {
		try {
		    // create Gson instance
		    Gson gson = new Gson();

		    // create a reader
		    Reader reader = Files.newBufferedReader(Paths.get(JsonPathConstant.JSONPATH));

		    Persons persons = gson.fromJson(reader, Persons.class);
		    List<Person> person = persons.getPerson();
		    
		    // close reader
		    reader.close();
		    
		    return person;
		    
		    
		    
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return null;
	}
}