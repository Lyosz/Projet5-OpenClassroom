package com.safetynet.webmicroservice.webdao;

import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.webmodel.Medicalrecord;

@Component
public interface MedicalRecordsDao {

	public Medicalrecord getMedicalRecordByNameAndLastname(String id);
	public Medicalrecord updateMedicalRecord(Medicalrecord medicalRecord);
	public Medicalrecord saveMedicalRecord(Medicalrecord medicalRecord);
	public boolean deleteMedicalRecord(String id);
}
