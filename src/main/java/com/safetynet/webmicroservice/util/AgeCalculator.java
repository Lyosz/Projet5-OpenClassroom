package com.safetynet.webmicroservice.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.webmodel.Medicalrecord;
@Component
public class AgeCalculator {
	
	@Autowired
	DataInMemory data;
	
	List<Medicalrecord> medicalRecords;
	
	public long calculator(String birthdate) {
		
		Date today = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yy"); 
		String strDate = dateFormat.format(today); 
		try {
			Date todayDate = dateFormat.parse(strDate);   
	        Date birthdateDate = dateFormat.parse(birthdate);
	        long time_difference = todayDate.getTime() - birthdateDate.getTime();
	        long years_difference = (time_difference / (1000l*60*60*24*365));
	        return years_difference;
		}
		catch (ParseException excep) {   
            excep.printStackTrace();   
        }   
          
		return 0;
	}
	
	@PostConstruct
	private void loadData() {
		medicalRecords = data.getMedicalRecords();
	}
}
