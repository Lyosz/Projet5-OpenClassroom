package com.safetynet.webmicroservice.webdao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.MedicalRecords;



@Component
public interface MedicalRecordsDao {

	public MedicalRecord findById(String id);
	public MedicalRecord update(MedicalRecord medicalRecord);
	public MedicalRecord save(MedicalRecord medicalRecord);
	public boolean delete(String id);
}
