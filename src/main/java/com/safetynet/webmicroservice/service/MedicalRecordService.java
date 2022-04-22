package com.safetynet.webmicroservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.webdaoimpl.MedicalRecordDaoImpl;
import com.safetynet.webmicroservice.webmodel.Medicalrecord;

@Component
public class MedicalRecordService{

	@Autowired
	private MedicalRecordDaoImpl medicalRecordDaoImpl;
	
	public MedicalRecordService() {
		
	}
	
	public MedicalRecordService(MedicalRecordDaoImpl medicalRecordDaoImplTest) {
		this.medicalRecordDaoImpl = medicalRecordDaoImplTest;
	}

	public Medicalrecord findById(String id) {
		
		return medicalRecordDaoImpl.getMedicalRecordByNameAndLastname(id);
	}

	public Medicalrecord update(Medicalrecord medicalRecord) {

		return medicalRecordDaoImpl.updateMedicalRecord(medicalRecord);
	}

	public Medicalrecord save(Medicalrecord medicalRecord) {
		
		return medicalRecordDaoImpl.saveMedicalRecord(medicalRecord);
	}

	public boolean delete(String id) {
		
		return medicalRecordDaoImpl.deleteMedicalRecord(id);
	}

	


}
