package com.safetynet.webmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.webdao.MedicalRecordsDao;
import com.safetynet.webmicroservice.webdaoimpl.MedicalRecordDaoImpl;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;

@Component
public class MedicalRecordsService{

	@Autowired
	private MedicalRecordDaoImpl medicalRecordService;
	
	public MedicalRecord findById(String id) {
		
		return medicalRecordService.getMedicalRecordByNameAndLastname(id);
	}

	public MedicalRecord update(MedicalRecord medicalRecord) {

		return medicalRecordService.updateMedicalRecord(medicalRecord);
	}

	public MedicalRecord save(MedicalRecord medicalRecord) {
		
		medicalRecordService.saveMedicalRecord(medicalRecord);
		return null;
	}

	public boolean delete(String id) {
		
		medicalRecordService.deleteMedicalRecord(id);
		return true;
	}

	


}
