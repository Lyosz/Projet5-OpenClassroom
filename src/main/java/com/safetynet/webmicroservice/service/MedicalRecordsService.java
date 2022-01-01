package com.safetynet.webmicroservice.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.util.IdToFirstAndLastName;
import com.safetynet.webmicroservice.webdao.MedicalRecordsDao;
import com.safetynet.webmicroservice.webdaoimpl.MedicalRecordDaoImpl;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;

@Component
public class MedicalRecordsService implements MedicalRecordsDao{

	@Autowired
	private MedicalRecordDaoImpl medicalRecordService;
	@Autowired
	private IdToFirstAndLastName idTo;
	
	
	@Override
	public MedicalRecord findById(String id) {
		String firstName = idTo.getFirstName(id);
		String lastName = idTo.getLastName(id);
		return medicalRecordService.getMedicalRecordByNameAndLastname(firstName, lastName);
	}

	@Override
	public MedicalRecord update(MedicalRecord medicalRecord) {
		// TODO Auto-generated method stub
		return medicalRecordService.updateMedicalRecord(medicalRecord);
	}


	@Override
	public MedicalRecord save(MedicalRecord medicalRecord) {
		medicalRecordService.saveMedicalRecord(medicalRecord);
		return null;
	}

	@Override
	public boolean delete(String id) {
		String firstName = idTo.getFirstName(id);
		String lastName = idTo.getLastName(id);
		medicalRecordService.deleteMedicalRecord(firstName, lastName);
		return true;
	}

	


}
