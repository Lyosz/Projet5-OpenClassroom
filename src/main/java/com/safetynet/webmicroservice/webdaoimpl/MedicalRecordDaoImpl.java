package com.safetynet.webmicroservice.webdaoimpl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.util.IdToFirstAndLastName;
import com.safetynet.webmicroservice.webdao.MedicalRecordsDao;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;

@Service
public class MedicalRecordDaoImpl implements MedicalRecordsDao{

	@Autowired
	DataInMemory data;
	@Autowired
	private IdToFirstAndLastName idTo;
	
	List<MedicalRecord> medicalRecords;
	
	@Override
	public MedicalRecord getMedicalRecordByNameAndLastname(String id){
		String firstname = idTo.getFirstName(id);
		String lastname = idTo.getLastName(id);
		for(MedicalRecord medicalRecordInfo : medicalRecords) {
			if (medicalRecordInfo.getFirstName().equals(firstname) && medicalRecordInfo.getLastName().equals(lastname)) {
	    		return medicalRecordInfo;
	    	}
	    	
	    
		}
		return null;
	}
	@Override
	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
		medicalRecords.add(medicalRecord);
		return medicalRecord;
	}
	
	@Override
	public boolean deleteMedicalRecord(String id) {
		String firstname = idTo.getFirstName(id);
		String lastname = idTo.getLastName(id);
		for(MedicalRecord medicalRecordInfo : medicalRecords) {
			if (medicalRecordInfo.getFirstName().equals(firstname) && medicalRecordInfo.getLastName().equals(lastname)) {
				medicalRecords.remove(medicalRecordInfo);
				return true;
	    	}
		
	}
		return false;
}
	@Override
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
	
	@PostConstruct
	private void loadData() {
		medicalRecords = data.getMedicalRecords();
	}
}