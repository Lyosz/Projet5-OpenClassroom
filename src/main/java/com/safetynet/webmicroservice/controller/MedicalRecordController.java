package com.safetynet.webmicroservice.controller;

import java.net.URI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.safetynet.webmicroservice.service.MedicalRecordService;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;

@RestController
public class MedicalRecordController {

	private static Logger log = LogManager.getLogger(MedicalRecordController.class);
	
	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@ResponseStatus(value=HttpStatus.CREATED)
	@PostMapping(path="/medicalRecord")
	public MedicalRecord postNewMedicalRecord(@RequestBody MedicalRecord medicalRecord) {
		
		MedicalRecord savedMedicalRecord = medicalRecordService.save(medicalRecord);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedMedicalRecord.getFirstName()).toUri();
		log.info("Medical Record saved in Db");
		//return ResponseEntity.created(location).build();	
		return savedMedicalRecord;
	}
	
	@ResponseStatus(value=HttpStatus.CREATED)
	@PutMapping(path="/medicalRecord/{id}")
	public MedicalRecord updateMedicalRecord(@PathVariable String id, @RequestBody MedicalRecord medicalRecord) {
		log.info("Medical Record with " + id + " correctly got");
		return medicalRecordService.save(medicalRecord);
	}
	
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@DeleteMapping(path="/medicalRecord/{id}")
	public boolean deleteMedicalRecord(@PathVariable String id) {
		log.info("Medical Record with " + id + " correctly deleted");
		return medicalRecordService.delete(id);
	}
}
