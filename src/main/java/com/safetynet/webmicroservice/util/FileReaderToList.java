package com.safetynet.webmicroservice.util;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.safetynet.webmicroservice.constants.JsonPathConstant;
import com.safetynet.webmicroservice.controller.MedicalRecordController;
import com.safetynet.webmicroservice.webmodel.Firestation;
import com.safetynet.webmicroservice.webmodel.Firestations;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.MedicalRecords;
import com.safetynet.webmicroservice.webmodel.Person;
import com.safetynet.webmicroservice.webmodel.Persons;
@Component
public class FileReaderToList {

	private static Logger log = LogManager.getLogger(MedicalRecordController.class);
	
	private String JSONPATH = JsonPathConstant.JSONPATH;
	
	private Reader reader;
	
	private Gson gson;
	
	private MedicalRecords medicalRecords;
	private Firestations firestations;
	private Persons persons;
	
	private List<MedicalRecord> medicalRecord;
	private List<Firestation> firestation;
	private List<Person> person;
	
	public FileReaderToList(){
		
	}
	
	public FileReaderToList(String JSONPATHTEST) {
		this.JSONPATH = JSONPATHTEST;
	}
	
	public List<MedicalRecord> getMedicalRecordToList() {
	try {
	    // create Gson instance
	    gson = new Gson();

	    // create a reader
	    reader = Files.newBufferedReader(Paths.get(JSONPATH));

	    medicalRecords = gson.fromJson(reader, MedicalRecords.class);
	    medicalRecord = medicalRecords.getMedicalRecords();
	    log.info("Medical Records?",medicalRecords);
	    // close reader
	    reader.close();
	    
	    return medicalRecord;
	    
	    
	    
	} catch (Exception ex) {
	    ex.printStackTrace();
	}
	return null;
}
	
	public MedicalRecords getMedicalRecordToListToVerify() {
		try {
		    // create Gson instance
		    gson = new Gson();

		    // create a reader
		    reader = Files.newBufferedReader(Paths.get(JSONPATH));

		    medicalRecords = gson.fromJson(reader, MedicalRecords.class);
		    log.info("Medical Records?",medicalRecords);
		    // close reader
		    reader.close();
		    
		    return medicalRecords;
		    
		    
		    
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
		    person = persons.getPerson();
		    
		    // close reader
		    reader.close();
		    
		    return person;
		    
		    
		    
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
		return null;
	}
	
}