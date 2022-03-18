package com.safetynet.webmicroservice.webmodel;

import java.util.List;

public class Address {

	private String firstname;
	private String lastname;
	private String phone;
	private long age;
	private String address;
	private List<String> medications;
	private List<String> allergies;

	public Address(String firstname, String lastname, String phone, long age, String address, List<String> medications,
			List<String> allergies) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.phone = phone;
		this.age = age;
		this.address = address;
		this.medications = medications;
		this.allergies = allergies;
	}

	public Address() {
		
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
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Address [firstname=" + firstname + ", lastname=" + lastname + ", phone=" + phone + ", age=" + age
				+ ", address=" + address + ", medications=" + medications + ", allergies=" + allergies + "]";
	}
	
}
