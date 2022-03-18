package com.safetynet.webmicroservice.webmodel;

public class Firestation {

	private String address;
	private String station;
	
	public Firestation() {
		
	}
	
	public Firestation(String address, String station) {
		super();
		this.address = address;
		this.station = station;
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
	
	@Override
	public String toString() {
		return "Firestation [address=" + address + ", station=" + station + "]";
	}

	@Override
	public boolean equals(Object obj) {
		
		Firestation anotherFirestation = (Firestation) obj;
		
		if(this.address != anotherFirestation.address) {
			return false;
		}
		if(this.station != anotherFirestation.station) {
			return false;
		}
		return true;
	}
	
	
}
