package com.safetynet.webmicroservice.webmodel;

import java.util.List;

public class Address {

	private String name;
	private String phone;
	private String age;
	private List<String> medications;
	private List<String> allergies;
	
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
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
	
	@Override
	public String toString() {
		return "Address [name=" + name + ", phone=" + phone + ", age=" + age + ", medications=" + medications
				+ ", allergies=" + allergies + "]";
	}
	
	
}
