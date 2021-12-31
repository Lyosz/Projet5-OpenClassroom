package com.safetynet.webmicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.util.AgeCalculator;
import com.safetynet.webmicroservice.webmodel.Fire;
import com.safetynet.webmicroservice.webmodel.Firestation;
import com.safetynet.webmicroservice.webmodel.Flood;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.Person;
@Service
public class CatastrophesService {

	@Autowired
	DataInMemory data;
	
	//This section will be changed
	List<Person> persons = data.listPersons;
	List<MedicalRecord> medicalRecords = data.listMedicalRecords;
	List<Firestation> firestations = data.listFirestation;
	AgeCalculator ageCalculator = new AgeCalculator();
	//end of section
	public List<Fire> fireAlert(String address) {
		List<Fire> personsAtAddress = null;
		for(Person person: persons) {
			if(person.getAddress().equals(address)) {
				for(MedicalRecord medicalRecord : medicalRecords) {
					if(medicalRecord.getFirstName().equals(person.getFirstName())
					    && medicalRecord.getLastName().equals(person.getLastName())) {
						for(Firestation firestation : firestations) {
							if(firestation.getAddress().equals(address)) {
								String birthdate = medicalRecord.getBirthdate();
								long age = ageCalculator.calculator(birthdate);
								personsAtAddress.add(new Fire(address, firestation.getStation(), person.getLastName(), person.getPhone(), 
								age, medicalRecord.getMedications(), medicalRecord.getAllergies()));
							}
						}
					}
				}
				
			}
		}
		return null;
	}
	
	public List<Flood> floodAlert(String[] stations){
		return null;
	}
}
