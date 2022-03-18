package com.safetynet.webmicroservice.webmodel;

import java.util.List;

public class Flood implements Catastrophes{

	private List<Address> address;

	public List<Address> getAddress() {
		return address;
	}

	public Flood(List<Address> address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Flood [address=" + address + "]";
	}
	
}
