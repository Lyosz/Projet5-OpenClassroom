package com.safetynet.webmicroservice.webdao;

import java.util.List;

import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.MedicalRecords;

public interface MedicalRecordsDao {

	public MedicalRecord findById(String id);
	public MedicalRecord update(MedicalRecord medicalRecord);
	public List<MedicalRecords>findAll();
	public MedicalRecord save(MedicalRecord medicalRecord);
	public MedicalRecord delete(String id);
}
