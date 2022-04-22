package com.safetynet.webmicroservice.util;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.safetynet.webmicroservice.webmodel.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.constants.JsonPathConstant;
import com.safetynet.webmicroservice.controller.MedicalRecordController;

@Component
public class FileReaderToList {

	private static Logger log = LogManager.getLogger(FileReaderToList.class);
	
	private String JSONPATH = JsonPathConstant.JSONPATH;
	
	private Reader reader;
	
	private Gson gson;
	
	private Medicalrecords medicalRecords;
	private Firestations firestations;
	private Persons persons;
	
	private List<Medicalrecord> medicalRecord;
	private List<Firestation> firestation;
	private List<Person> person;

	public FileReaderToList(){

	}
	
	public FileReaderToList(String JSONPATHTEST){
		this.JSONPATH = JSONPATHTEST;
		
	}
	
	public List<Medicalrecord> getMedicalRecordToList() {
	try {
	    // create Gson instance
	    gson = new Gson();

	    // create a reader
	    reader = Files.newBufferedReader(Paths.get(JSONPATH));
	    
	    medicalRecords = gson.fromJson(reader, Medicalrecords.class);
		medicalRecord = medicalRecords.getMedicalRecords();

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
		    gson = new Gson();

		    // create a reader
		    reader = Files.newBufferedReader(Paths.get(JSONPATH));
		    
		    firestations = gson.fromJson(reader, Firestations.class);
		    firestation = firestations.getFirestation();
		    
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
		    gson = new Gson();

		    // create a reader
		    reader = Files.newBufferedReader(Paths.get(JSONPATH));

		    persons = gson.fromJson(reader, Persons.class);
		    person = persons.getPersons();
		    
		    // close reader
		    reader.close();
		    
		    return person;
		    
		    
		    
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	
}