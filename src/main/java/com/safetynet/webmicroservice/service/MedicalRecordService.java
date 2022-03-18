package com.safetynet.webmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.webdaoimpl.MedicalRecordDaoImpl;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;

@Component
public class MedicalRecordService{

	@Autowired
	private MedicalRecordDaoImpl medicalRecordDaoImpl;
	
	public MedicalRecordService() {
		
	}
	
	public MedicalRecordService(MedicalRecordDaoImpl medicalRecordDaoImplTest) {
		this.medicalRecordDaoImpl = medicalRecordDaoImplTest;
	}

	public MedicalRecord findById(String id) {
		
		return medicalRecordDaoImpl.getMedicalRecordByNameAndLastname(id);
	}

	public MedicalRecord update(MedicalRecord medicalRecord) {

		return medicalRecordDaoImpl.updateMedicalRecord(medicalRecord);
	}

	public MedicalRecord save(MedicalRecord medicalRecord) {
		
		return medicalRecordDaoImpl.saveMedicalRecord(medicalRecord);
	}

	public boolean delete(String id) {
		
		return medicalRecordDaoImpl.deleteMedicalRecord(id);
	}

	


}
