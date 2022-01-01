package com.safetynet.webmicroservice.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.webdao.FirestationDao;
import com.safetynet.webmicroservice.webmodel.Firestations;
@Component
public class FirestationService implements FirestationDao{

	@Override
	public List<Firestations> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findById(int station) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findById(String address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String save(Firestations firestation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(Firestations firestation) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
