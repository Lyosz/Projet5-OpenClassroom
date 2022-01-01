package com.safetynet.webmicroservice.webdao;

import org.springframework.stereotype.Component;

import com.safetynet.webmicroservice.webmodel.Person;
@Component
public interface PersonDao {

	
    public Person getPersonByNameAndLastname(String id);
    public Person savePerson(Person person);
    public Person updatePerson(Person person);
    public boolean deletePerson(String id);
}
