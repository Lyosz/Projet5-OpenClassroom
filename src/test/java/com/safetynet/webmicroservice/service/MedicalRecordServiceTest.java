package com.safetynet.webmicroservice.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webmicroservice.service.MedicalRecordService;
import com.safetynet.webmicroservice.webdaoimpl.MedicalRecordDaoImpl;
import com.safetynet.webmicroservice.webmodel.Medicalrecord;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordServiceTest {

	private List<String> medications;
	private List<String> allergies;

	private Medicalrecord medicalRecord;
	
	private String medications1 = "aznol:350mg";
	private String medications2 = "hydrapermazol:100mg";
	
	private String allergies1 = "nillacilan";
	
	private MedicalRecordService medicalRecordService;

	@Mock
	private MedicalRecordDaoImpl medicalRecordDaoImpl;
	
	private String id;
	
	private Medicalrecord medicalRecordServiceTest;
	
	private boolean medicalRecordServiceTestBoolean;
	
	@BeforeEach
	public void load() {
		
		medicalRecordService = new MedicalRecordService(medicalRecordDaoImpl);
		
		medications = new ArrayList<String>();
		medications.add(medications1);
		medications.add(medications2);
		
		allergies = new ArrayList<String>();
		allergies.add(allergies1);
		
		medicalRecord = new Medicalrecord("John", "Boyd","03/06/1984", medications, allergies);
	}
	
	@Test
	public void saveMedicalRecordTest() {
		
		when(medicalRecordDaoImpl.saveMedicalRecord(medicalRecord)).thenReturn(medicalRecord);
		medicalRecordServiceTest = medicalRecordService.save(medicalRecord);
		Assertions.assertTrue(medicalRecordServiceTest.equals(medicalRecord), "The MedicalRecord object is'nt identical");
	}
	
	@Test
	public void deleteMedicalRecordTest() {
		
		when(medicalRecordDaoImpl.deleteMedicalRecord(id)).thenReturn(true);
		medicalRecordServiceTestBoolean = medicalRecordService.delete(id);
		Assertions.assertEquals(medicalRecordServiceTestBoolean, true, "The MedicalRecord object is'nt identical");
	}
	
	@Test
	public void updateMedicalRecordTest() {
		
		when(medicalRecordDaoImpl.updateMedicalRecord(medicalRecord)).thenReturn(medicalRecord);
		medicalRecordServiceTest = medicalRecordService.update(medicalRecord);
		Assertions.assertTrue(medicalRecordServiceTest.equals(medicalRecord), "The MedicalRecord object is'nt identical");
	}
	
	@Test
	public void getMedicalRecordTest() {
		
		when(medicalRecordDaoImpl.getMedicalRecordByNameAndLastname(id)).thenReturn(medicalRecord);
		medicalRecordServiceTest = medicalRecordService.findById(id);
		Assertions.assertTrue(medicalRecordServiceTest.equals(medicalRecord), "The MedicalRecord object is'nt identical");
	}
}
