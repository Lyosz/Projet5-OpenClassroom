package com.safetynet.webmicroservice.constants;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.safetynet.webmicroservice.util.FileReaderToList;
import com.safetynet.webmicroservice.webmodel.Firestation;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.Person;

public class DataInMemory {

	@Autowired
	FileReaderToList fileReaderToList;
	
	public List<MedicalRecord> listMedicalRecords = fileReaderToList.getMedicalRecordToList();
	public List<Person> listPersons = fileReaderToList.getPersonToList();
	public List<Firestation> listFirestation = fileReaderToList.getFirestationToList();
	
	
}
