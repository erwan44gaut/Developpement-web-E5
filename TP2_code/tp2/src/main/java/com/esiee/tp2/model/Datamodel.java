package com.esiee.tp2.model;

import java.util.Map;

import com.esiee.tp2.domain.Civility;
import com.esiee.tp2.domain.Function;
import com.esiee.tp2.domain.Person;

public class Datamodel {
	
	private static Datamodel datamodelInstance;
	
	public static Datamodel getInstance() {
		if (datamodelInstance == null) {
			datamodelInstance = new Datamodel();
		}
		
		return datamodelInstance;
	}
	
	private Map<Long, Civility> civilities;
    private Map<Long, Person> persons;
    private Map<Long, Function> functions;
    
    private void initData() {
        initCivilities();
        initPersons();
        initFunctions();
    }
	
	private Datamodel() {
		initData();
	}

    private void initPersons() {
        Person personOne = new Person();
        personOne.setId(1L);
        personOne.setFirstname("Rene");
        personOne.setLastname("Dubois");
        personOne.setMail("rene.dubois@esiee.tp2");
        personOne.setMobilePhone("01-45-85-02-51");
        personOne.setLogin("rdubois");
        personOne.setPassword("password123");
        personOne.setCivility(civilities.get(1L));
        personOne.setFunction(functions.get(1L));

        persons.put(personOne.getId(), personOne);
    }
    
    private void initCivilities( ) {
    	Civility civilityOne = new Civility();
        civilityOne.setId(1L);
        civilityOne.setCode("M");
        civilityOne.setLabel("Monsieur");
        civilities.put(civilityOne.getId(), civilityOne);
        
        Civility civilityTwo = new Civility();
        civilityTwo.setId(2L);
        civilityTwo.setCode("Mme");
        civilityTwo.setLabel("Madame");
        civilities.put(civilityTwo.getId(), civilityTwo);
    }
    
	private void initFunctions( ) {
    	Function functionOne = new Function();
    	functionOne.setId(1L);
    	functionOne.setCode("DEV");
    	functionOne.setLabel("Developer");
    	functions.put(functionOne.getId(), functionOne);
    	
    	Function functionTwo = new Function();
    	functionTwo.setId(2L);
    	functionTwo.setCode("MAN");
    	functionTwo.setLabel("Manager");
    	functions.put(functionTwo.getId(), functionTwo);
    }
	
	public Map<Long, Person> getPersons() {
        return persons;
    }

    public Map<Long, Civility> getCivilities() {
        return civilities;
    }

    public Map<Long, Function> getFunctions() {
        return functions;
    }
}
