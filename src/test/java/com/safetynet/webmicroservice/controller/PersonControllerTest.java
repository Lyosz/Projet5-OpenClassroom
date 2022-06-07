package com.safetynet.webmicroservice.controller;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.safetynet.webmicroservice.service.PersonService;
import com.safetynet.webmicroservice.webmodel.Person;

@WebMvcTest(controllers = PersonController.class)
public class PersonControllerTest {//extends AbstractTest {
	
	@InjectMocks
	private PersonController personController;
	
	@Mock
	private PersonService personService;
	
	private String content;
	
	private int status;
	
	private Person person;

	private String personStr;
	
	private MvcResult mvcResult;
	
	private RequestBuilder requestBuilder;
	
	@Autowired
	private MockMvc mockMvc;
	
    @BeforeEach
    public void setup() {
        //this.mockMvc = MockMvcBuilders.standaloneSetup(new PersonController()).build();
    	person = new Person("Moris", "Dupond", "Banlieue 13", "tredf", "123", "065061231", "qosdo@gamail.comfr");

    }

    @Test
	public void getPerson() throws Exception{
		
		
		when(personService.findById(Mockito.anyString())).thenReturn(person);
		
		requestBuilder = MockMvcRequestBuilders.get(
				"/person").accept(
				MediaType.APPLICATION_JSON);

		mvcResult = mockMvc.perform(requestBuilder).andReturn();
		   
		status = mvcResult.getResponse().getStatus();
		Assertions.assertEquals(200, status);
		   
		content = mvcResult.getResponse().getContentAsString();
		Assertions.assertEquals(content, personStr, "String objects not identical");

	}
	
    @Test
	public void deletePerson() throws Exception {
		
		   
    		requestBuilder = MockMvcRequestBuilders.delete(
    				"/person").accept(
    				MediaType.APPLICATION_JSON);

			mvcResult = mockMvc.perform(requestBuilder).andReturn();
		   
		   status = mvcResult.getResponse().getStatus();
		   Assertions.assertEquals(204, status);
		   
		   content = mvcResult.getResponse().getContentAsString();
		   Assertions.assertEquals(content, "Product is deleted successfully");
	}
	
    @Test
	public void savePerson() throws Exception {
		   
    		requestBuilder = MockMvcRequestBuilders.post(
    				"/person").accept(
    				MediaType.APPLICATION_JSON);

			mvcResult = mockMvc.perform(requestBuilder).andReturn();
		   
		   status = mvcResult.getResponse().getStatus();
		   Assertions.assertEquals(201, status);
		   
		   content = mvcResult.getResponse().getContentAsString();
		   Assertions.assertEquals(content, "Product is created successfully");
	}
	
    @Test
	public void updatePerson() throws Exception {
		
		   
    		requestBuilder = MockMvcRequestBuilders.put(
				"/person").accept(
				MediaType.APPLICATION_JSON);

    		mvcResult = mockMvc.perform(requestBuilder).andReturn();
		   
		   status = mvcResult.getResponse().getStatus();
		   Assertions.assertEquals(201, status);
		   
		   content = mvcResult.getResponse().getContentAsString();
		   Assertions.assertEquals(content, "Product is updated successfully");
	}
}

