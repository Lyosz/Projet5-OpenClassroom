package com.safetynet.webmicroservice.webdaoimpl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.util.AgeCalculator;
import com.safetynet.webmicroservice.util.StringToListStation;
import com.safetynet.webmicroservice.webmodel.Address;
import com.safetynet.webmicroservice.webmodel.Fire;
import com.safetynet.webmicroservice.webmodel.Firestation;
import com.safetynet.webmicroservice.webmodel.Flood;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;
import com.safetynet.webmicroservice.webmodel.Person;

@Repository
public class CatastrophesDaoImpl {

	@Autowired
	DataInMemory data;
	@Autowired
	AgeCalculator ageCalculator;
	@Autowired
	StringToListStation stringToListStation;
	
	List<Person> persons;
	List<MedicalRecord> medicalRecords;
	List<Firestation> firestations;
	
	List<Fire> personsAtAddress;
	
	Flood flood;
	List<Address> addresses;
	
	public List<Fire> getfireAlert(String address) {
		personsAtAddress = null;
		
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
		return personsAtAddress;
	}
	
	public Flood getfloodAlert(String strStations){
		addresses = null;
		List<String> stations = stringToListStation.toListStation(strStations);
		for(String station: stations) {
			
			for(Firestation firestation: firestations) {
				
				if(firestation.getStation().equals(station)) {
					for(Person person: persons) {
						
						if(person.getAddress().equals(firestation.getAddress())) {
							for(MedicalRecord medicalRecord: medicalRecords) {
								
								if(medicalRecord.getFirstName().equals(person.getFirstName())
								    && medicalRecord.getLastName().equals(person.getLastName())) {
									String birthdate = medicalRecord.getBirthdate();
									long age = ageCalculator.calculator(birthdate);
									addresses.add(new Address(person.getFirstName(), person.getLastName(), person.getPhone(), age, person.getAddress(), medicalRecord.getMedications(), medicalRecord.getAllergies()));
								}
							}
						}
					}
				}
			}
		}
		return new Flood(addresses);
	}
	
	@PostConstruct
	private void loadData() {
		persons = data.getPerson();
		medicalRecords = data.getMedicalRecords();
		firestations = data.getFirestation();
	}
}
