package com.safetynet.webmicroservice.webmodel;

import java.util.List;

public class Fire {

	private String name;
	private String phone;
	private String age;
	private List<String> medications;
	private List<String> allergies;
	
	public String getNom() {
		return name;
	}
	public void setNom(String nom) {
		this.name = nom;
	}
	public String getNumero() {
		return phone;
	}
	public void setNumero(String numero) {
		this.phone = numero;
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
		return "Fire [name=" + name + ", phone=" + phone + ", age=" + age + ", medications=" + medications
				+ ", allergies=" + allergies + "]";
	}
	
	
}
