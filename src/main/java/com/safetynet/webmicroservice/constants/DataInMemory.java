package com.safetynet.webmicroservice.constants;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.util.FileReaderToList;
import com.safetynet.webmicroservice.webmodel.Firestation;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.Person;
@Component
public class DataInMemory {

	@Autowired
	FileReaderToList fileReaderToList;
	
	public List<MedicalRecord> listMedicalRecords;
	public List<Person> listPersons;
	public List<Firestation> listFirestation;

	public List<MedicalRecord> getMedicalRecords(){
		return listMedicalRecords;
	}
	
	public List<Firestation> getFirestation(){
		return listFirestation;
	}
	
	public List<Person> getPerson(){
		return listPersons;
	}
	
	@PostConstruct
	public void loadData() {
		listMedicalRecords = fileReaderToList.getMedicalRecordToList();
		listPersons = fileReaderToList.getPersonToList();
		listFirestation = fileReaderToList.getFirestationToList();
	}
}
