package com.safetynet.webmicroservice.webmodel;

import java.util.ArrayList;
import java.util.List;

public class Fire implements Catastrophes{

	private String address;
	private String station;
	private String name;
	private String phone;
	private long age;
	private List<String> medications;
	private List<String> allergies;
	
	public Fire() {
		
	}
	
	
	public Fire(String address, String station, String name, String phone, long age, List<String> medications,
				List<String> allergies) {
		
		this.address = address;
		this.station = station;
		this.name = name;
		this.phone = phone;
		this.age = age;
		this.medications = medications;
		this.allergies = allergies;
	}


	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStation() {
		return station;
	}
	public void setStation(String station) {
		this.station = station;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public long getAge() {
		return age;
	}
	public void setAge(long age) {
		this.age = age;
	}
	public List<String> getMedications() {
		return medications;
	}
	public void setMedications(List<String> medications) {
		this.medications = medications;
	}
	public List<String> getAllergies() {
		return allergies;
	}
	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}
	
	
	
}
