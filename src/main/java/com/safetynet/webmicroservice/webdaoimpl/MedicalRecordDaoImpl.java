package com.safetynet.webmicroservice.webdaoimpl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.util.IdToFirstAndLastName;
import com.safetynet.webmicroservice.webdao.MedicalRecordsDao;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.MedicalRecords;

@Repository
public class MedicalRecordDaoImpl implements MedicalRecordsDao{

	private static final Logger logger = LoggerFactory.getLogger(MedicalRecordDaoImpl.class);
	
	@Autowired
	private DataInMemory data;
	@Autowired
	private IdToFirstAndLastName idTo;
	
	private List<MedicalRecord> medicalRecords;
	private String firstname;
	private String lastname;
	
	private MedicalRecords MedRecord;
	
	/**
	 * For test use only
	 * @param medicalRecordsTest = In memory data to use in tests
	 */
	public MedicalRecordDaoImpl(List<MedicalRecord> medicalRecordsTest) {
		
		this.medicalRecords = medicalRecordsTest;
	}
	
	public MedicalRecordDaoImpl() {
		
	}
	
	@Override
	public MedicalRecord getMedicalRecordByNameAndLastname(String id){
		firstname = idTo.getFirstName(id);
		lastname = idTo.getLastName(id);
		for(MedicalRecord medicalRecordInfo : medicalRecords) {
			if (medicalRecordInfo.getFirstName().equals(firstname) && medicalRecordInfo.getLastName().equals(lastname)) {
	    		return medicalRecordInfo;
	    	}
	    	
	    
		}
		return null;
	}
	@Override
	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord) {
		logger.info("All Medical Records: " + String.valueOf(MedRecord));
		logger.info("Medical Record?: " + String.valueOf(medicalRecord));
		medicalRecords.add(medicalRecord);
		return medicalRecord;
	}
	
	@Override
	public boolean deleteMedicalRecord(String id) {
		firstname = idTo.getFirstName(id);
		lastname = idTo.getLastName(id);
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
		firstname = medicalRecord.getFirstName();
		lastname = medicalRecord.getLastName();
		
		for(MedicalRecord medicalRecordInfo : medicalRecords) {
			if (medicalRecordInfo.getFirstName().equals(firstname) && medicalRecordInfo.getLastName().equals(lastname)) {
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
		MedRecord = data.getMedicalRecordsToVerify();
	}
}