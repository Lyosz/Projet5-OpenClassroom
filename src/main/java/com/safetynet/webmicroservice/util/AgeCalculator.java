package com.safetynet.webmicroservice.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.safetynet.webmicroservice.constants.DataInMemory;
import com.safetynet.webmicroservice.webmodel.MedicalRecord;

public class AgeCalculator {
	
	@Autowired
	DataInMemory data;
	
	//This section will be changed
	List<MedicalRecord> medicalRecords = data.listMedicalRecords;
	//end of section
	
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
}
