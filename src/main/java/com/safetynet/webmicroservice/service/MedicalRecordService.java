package com.safetynet.webmicroservice.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
@Service
public class MedicalRecordService {

	
	DataInMemory data;
	
	//This section will be changed
	List<MedicalRecord> medicalRecords = data.listMedicalRecords;
	//end of section
	
	public MedicalRecord getMedicalRecordByNameAndLastname(String firstName, String lastName){
	
		for(MedicalRecord medicalRecordInfo : medicalRecords) {
			if (medicalRecordInfo.getFirstName().equals(firstName) && medicalRecordInfo.getLastName().equals(lastName)) {
	    		return medicalRecordInfo;
	    	}
	    	
	    
		}
		return null;
	}
	
	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecords.add(medicalRecord);
		return medicalRecord;
	}
	
	public boolean deleteMedicalRecord(String firstName, String lastName) {
		
		for(MedicalRecord medicalRecordInfo : medicalRecords) {
			if (medicalRecordInfo.getFirstName().equals(firstName) && medicalRecordInfo.getLastName().equals(lastName)) {
				medicalRecords.remove(medicalRecordInfo);
				return true;
	    	}
		
	}
		return false;
}
	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord) {
		
		String firstName = medicalRecord.getFirstName();
		String lastName = medicalRecord.getLastName();
		
		for(MedicalRecord medicalRecordInfo : medicalRecords) {
			if (medicalRecordInfo.getFirstName().equals(firstName) && medicalRecordInfo.getLastName().equals(lastName)) {
				medicalRecords.remove(medicalRecordInfo);
				medicalRecords.add(medicalRecord);
				return medicalRecord;
	    	}
		
	}
		return null;
	}
}