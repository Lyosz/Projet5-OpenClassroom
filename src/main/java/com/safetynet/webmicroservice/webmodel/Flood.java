package com.safetynet.webmicroservice.webmodel;

import java.util.List;

public class Flood {

	private List<Address> address;

	public List<Address> getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Flood [address=" + address + "]";
	}
	
	
}