package com.safetynet.webmicroservice.service;


import java.util.List;


import com.safetynet.webmicroservice.util.FileReaderToList;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;

public class MedicalRecordService {

	public MedicalRecord getMedicalRecordByNameAndLastname(String firstName, String lastName){
	
		FileReaderToList listFromFile = new FileReaderToList();
		List<MedicalRecord> medicalRecords = listFromFile.getMedicalRecordToList();
		for(MedicalRecord medicalRecord : medicalRecords) {
			if (medicalRecord.getFirstName().equals(firstName) && medicalRecord.getLastName().equals(lastName)) {
	    		//personInfo.setFirstName("YoBoy");
		    	System.out.println(medicalRecord);
		    	break;

	    	}
	    	//System.out.println(personInfo);
	    
		}
		return null;
	}
	
	public List<MedicalRecord> saveMedicalRecord(MedicalRecord medicalRecord) {
		return null;
	}
	
	public void deleteMedicalRecord(String firstName, String lastName) {

		
	}
}
