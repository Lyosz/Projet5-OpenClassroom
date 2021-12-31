package com.safetynet.webmicroservice.webdao;

import com.safetynet.webmicroservice.webmodel.Person;

public interface PersonDao {

	
    public Person findById(String id);
    public Person save(Person person);
    public Person update(Person person);
    public boolean delete(String id);
}
