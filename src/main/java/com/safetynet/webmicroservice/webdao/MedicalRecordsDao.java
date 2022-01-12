package com.safetynet.webmicroservice.webdao;

import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.webmodel.MedicalRecord;

@Component
public interface MedicalRecordsDao {

	public MedicalRecord getMedicalRecordByNameAndLastname(String id);
	public MedicalRecord updateMedicalRecord(MedicalRecord medicalRecord);
	public MedicalRecord saveMedicalRecord(MedicalRecord medicalRecord);
	public boolean deleteMedicalRecord(String id);
}
