package com.safetynet.webmicroservice.webdaoimpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatastrophesDaoTest {

	private CatastrophesDaoImpl catastrophesDao;
	private String address;
	private String stations;
	
	@BeforeEach
	public void load() {
		catastrophesDao = new CatastrophesDaoImpl();
	}
	
	@Test
	public void getFire() {
		catastrophesDao.getfireAlert(address);
	}
	
	public void getFlood() {
		catastrophesDao.getfloodAlert(stations);
	}
}
