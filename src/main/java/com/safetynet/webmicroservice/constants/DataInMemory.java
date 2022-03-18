package com.safetynet.webmicroservice.constants;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.util.FileReaderToList;
import com.safetynet.webmicroservice.webmodel.Firestation;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.MedicalRecords;
import com.safetynet.webmicroservice.webmodel.Person;

@Component
public class DataInMemory {

	@Autowired
	FileReaderToList fileReaderToList;
	
	private List<MedicalRecord> listMedicalRecords;
	private List<Person> listPersons;
	private List<Firestation> listFirestation;
	
	private MedicalRecords medicalRecordsToVerify;

	public List<MedicalRecord> getMedicalRecords(){
		return listMedicalRecords;
	}
	
	public List<Firestation> getFirestation(){
		return listFirestation;
	}
	
	public List<Person> getPerson(){
		return listPersons;
	}
	
	public MedicalRecords getMedicalRecordsToVerify(){
		return medicalRecordsToVerify;
	}
	
	@PostConstruct
	public void loadData() {
		listMedicalRecords = fileReaderToList.getMedicalRecordToList();
		listPersons = fileReaderToList.getPersonToList();
		listFirestation = fileReaderToList.getFirestationToList();
		medicalRecordsToVerify = fileReaderToList.getMedicalRecordToListToVerify();
	}
	
}
