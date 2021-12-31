package com.safetynet.webmicroservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.webmicroservice.webdaoimpl.MedicalRecordsDaoImpl;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;

@RestController
public class MedicalRecordController {

	@Autowired
	private MedicalRecordsDaoImpl medicalRecordDao;
	
	@PostMapping(value="/medicalRecord")
	public MedicalRecord postNewMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordDao.save(medicalRecord);
		
	}
	@PutMapping(value="/medicalRecord/{id}")
	public MedicalRecord updateMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		return medicalRecordDao.save(medicalRecord);
	}
	
	@DeleteMapping(value="/medicalRecord/{id}")
	public boolean deleteMedicalRecord(@PathVariable String id) {
		return medicalRecordDao.delete(id);
	}
}
