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
import com.safetynet.webmicroservice.webmodel.Medicalrecord;

@RestController
public class MedicalRecordController {

	private static Logger log = LogManager.getLogger(MedicalRecordController.class);
	
	@Autowired
	private MedicalRecordService medicalRecordService;
	
	@PostMapping(path="/medicalRecord")
	public ResponseEntity<Medicalrecord> postNewMedicalRecord(@RequestBody Medicalrecord medicalRecord) {
		
		Medicalrecord savedMedicalRecord = medicalRecordService.save(medicalRecord);
		//URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedMedicalRecord.getFirstName()).toUri();
		log.info("Medical Record saved in Db");
		return new ResponseEntity<>(savedMedicalRecord, HttpStatus.CREATED);
	}
	
	@PutMapping(path="/medicalRecord/{id}")
	public ResponseEntity<Medicalrecord> updateMedicalRecord(@PathVariable String id, @RequestBody Medicalrecord medicalRecord) {
		Medicalrecord updateMedicalRecord = medicalRecordService.update(medicalRecord);

		if(updateMedicalRecord==null){
			log.error("Medical Record with " + id + " was not found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		log.info("Medical Record with " + id + " correctly update");
		return new ResponseEntity<>(updateMedicalRecord, HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/medicalRecord/{id}")
	public ResponseEntity<String> deleteMedicalRecord(@PathVariable String id) {
		boolean deletedMedicalRecordBoll = medicalRecordService.delete(id);
		if(deletedMedicalRecordBoll==true) {
			log.info("Medical Record with " + id + " correctly deleted");
			return new ResponseEntity<>("Succesfully deleted the Medical Record of id: " + id, HttpStatus.NO_CONTENT);
		}
			log.error("Medical Record with " + id + " was not found");
			return new ResponseEntity<>("An error occured, the Medical Record of id: " + id +" was not found", HttpStatus.NOT_FOUND);
		}
		
	}

