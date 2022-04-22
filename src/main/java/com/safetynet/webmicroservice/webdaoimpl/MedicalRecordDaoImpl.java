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
import com.safetynet.webmicroservice.webmodel.Medicalrecord;
import com.safetynet.webmicroservice.webmodel.Medicalrecords;

@Repository
public class MedicalRecordDaoImpl implements MedicalRecordsDao{

	private static final Logger logger = LoggerFactory.getLogger(MedicalRecordDaoImpl.class);
	
	@Autowired
	private DataInMemory data;
	@Autowired
	private IdToFirstAndLastName idTo;
	
	private List<Medicalrecord> medicalRecords;
	private String firstname;
	private String lastname;
	
	/**
	 * For test use only
	 * @param medicalRecordsTest = In memory data to use in tests
	 */
	public MedicalRecordDaoImpl(List<Medicalrecord> medicalRecordsTest) {
		
		this.medicalRecords = medicalRecordsTest;
	}
	
	public MedicalRecordDaoImpl() {
		
	}
	
	@Override
	public Medicalrecord getMedicalRecordByNameAndLastname(String id){
		firstname = idTo.getFirstName(id);
		lastname = idTo.getLastName(id);
		for(Medicalrecord medicalRecordInfo : medicalRecords) {
			if (medicalRecordInfo.getFirstName().equals(firstname) && medicalRecordInfo.getLastName().equals(lastname)) {
	    		return medicalRecordInfo;
	    	}
	    	
	    
		}
		return null;
	}
	@Override
	public Medicalrecord saveMedicalRecord(Medicalrecord medicalRecord) {
		medicalRecords.add(medicalRecord);
		return medicalRecord;
	}
	
	@Override
	public boolean deleteMedicalRecord(String id) {
		firstname = idTo.getFirstName(id);
		lastname = idTo.getLastName(id);
		for(Medicalrecord medicalRecordInfo : medicalRecords) {
			if (medicalRecordInfo.getFirstName().equals(firstname) && medicalRecordInfo.getLastName().equals(lastname)) {
				medicalRecords.remove(medicalRecordInfo);
				return true;
	    	}
		
	}
		return false;
}
	@Override
	public Medicalrecord updateMedicalRecord(Medicalrecord medicalRecord) {
		firstname = medicalRecord.getFirstName();
		lastname = medicalRecord.getLastName();
		
		for(Medicalrecord medicalRecordInfo : medicalRecords) {
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
	}
}