package com.safetynet.webmicroservice.webcontroller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

public class MedicalRecordController {

	@PostMapping(value="/medicalRecord")
	public String postNewMedicalRecord(String medicalRecord) {
		return "New Medical Record";
		
	}
	@PutMapping(value="/medicalRecord/{id}")
	public String updateMedicalRecord(@PathVariable String id) {
		return "Replacement of the Medical Record";
	}
	
	@DeleteMapping(value="/medicalRecord/{id}")
	public String deleteMedicalRecord(@PathVariable String id) {
		return "Medical Record deleted";
	}
}
