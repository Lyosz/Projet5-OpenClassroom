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
import com.safetynet.webmicroservice.webmodel.Medicalrecord;
import com.safetynet.webmicroservice.webmodel.Person;

@ExtendWith(MockitoExtension.class)
public class MedicalRecordDaoImplTest {
	
	private MedicalRecordDaoImpl medicalRecordDao;
	
	private Medicalrecord medicalRecord;
	private Medicalrecord medicalRecordFromData1;
	private Medicalrecord medicalRecordFromData2;
	private Medicalrecord medicalRecordToSave;
	private Medicalrecord medicalRecordToUpdate;
	
	private List<Medicalrecord> medicalRecords;
	private List<Medicalrecord> medicalRecordFromFalseData;
	
	private String id;
	
	@Mock
	private DataInMemory data;
	
	@BeforeEach
	public void load() {
		medicalRecordFromFalseData = new ArrayList<Medicalrecord>();
		medicalRecordFromFalseData.add(medicalRecordFromData1);
		medicalRecordFromFalseData.add(medicalRecordFromData2);
		
		when(data.getMedicalRecords()).thenReturn(medicalRecordFromFalseData);
		medicalRecords = data.getMedicalRecords();
	}
	
	@Test
	public void findById(){
		
		medicalRecordDao = new MedicalRecordDaoImpl(medicalRecords);
		medicalRecordDao.getMedicalRecordByNameAndLastname(id);
		Assertions.assertTrue(medicalRecords.contains(medicalRecord));
	}
	

	
	@Test
	public void save() {
		
		medicalRecordDao = new MedicalRecordDaoImpl(medicalRecords);
		medicalRecordDao.saveMedicalRecord(medicalRecord);
		Assertions.assertTrue(medicalRecords.contains(medicalRecord));
	}
	
	@Test
	public void deleteByAddress() {
		
		medicalRecordDao = new MedicalRecordDaoImpl(medicalRecords);
		medicalRecordDao.deleteMedicalRecord(id);
		Assertions.assertFalse(medicalRecords.contains(medicalRecord));
	}
	
	@Test
	public void update() {
		
		medicalRecordDao = new MedicalRecordDaoImpl(medicalRecords);
		medicalRecordDao.updateMedicalRecord(medicalRecord);
		Assertions.assertTrue(medicalRecords.contains(medicalRecord));
	}
}
