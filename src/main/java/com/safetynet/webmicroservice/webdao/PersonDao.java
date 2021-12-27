package com.safetynet.webmicroservice.webdao;

import com.safetynet.webmicroservice.webmodel.Persons;

public interface PersonDao {

	
    public String findById(String id);
    public String save(Persons person);
    public String findAll();
    public String update(Persons person);
}
