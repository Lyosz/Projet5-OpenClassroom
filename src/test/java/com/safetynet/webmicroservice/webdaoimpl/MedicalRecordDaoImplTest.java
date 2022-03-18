package com.safetynet.webmicroservice.webdaoimpl;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.Person;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordDaoImplTest {
	
	private MedicalRecordDaoImpl medicalRecordDao;
	
	private MedicalRecord medicalRecord;
	private MedicalRecord medicalRecordFromData1;
	private MedicalRecord medicalRecordFromData2;
	private MedicalRecord medicalRecordToSave;
	private MedicalRecord medicalRecordToUpdate;
	
	private List<MedicalRecord> medicalRecords;
	private List<MedicalRecord> medicalRecordFromFalseData;
	
	private String id;
	
	@Mock
	private DataInMemory data;
	
	@BeforeEach
	public void load() {
		medicalRecordFromFalseData = new ArrayList<MedicalRecord>();
		medicalRecordFromFalseData.add(medicalRecordFromData1);
		medicalRecordFromFalseData.add(medicalRecordFromData2);
	}
	
	@Test
	public void findById(){
		
		when(data.getMedicalRecords()).thenReturn(medicalRecordFromFalseData);
		
		medicalRecords = data.getMedicalRecords();
		
		medicalRecordDao = new MedicalRecordDaoImpl(medicalRecords);
		medicalRecordDao.getMedicalRecordByNameAndLastname(id);
		Assertions.assertTrue(medicalRecords.contains(medicalRecord));
	}
	

	
	@Test
	public void save() {
		
		when(data.getMedicalRecords()).thenReturn(medicalRecordFromFalseData);
		
		medicalRecords = data.getMedicalRecords();
		
		medicalRecordDao = new MedicalRecordDaoImpl(medicalRecords);
		medicalRecordDao.saveMedicalRecord(medicalRecord);
		Assertions.assertTrue(medicalRecords.contains(medicalRecord));
	}
	
	@Test
	public void deleteByAddress() {
		
		when(data.getMedicalRecords()).thenReturn(medicalRecordFromFalseData);
		
		medicalRecords = data.getMedicalRecords();
		
		medicalRecordDao = new MedicalRecordDaoImpl(medicalRecords);
		medicalRecordDao.deleteMedicalRecord(id);
		Assertions.assertFalse(medicalRecords.contains(medicalRecord));
	}
	
	@Test
	public void update() {
		
		when(data.getMedicalRecords()).thenReturn(medicalRecordFromFalseData);
		
		medicalRecords = data.getMedicalRecords();
		
		medicalRecordDao = new MedicalRecordDaoImpl(medicalRecords);
		medicalRecordDao.updateMedicalRecord(medicalRecord);
		Assertions.assertTrue(medicalRecords.contains(medicalRecord));
	}
}
