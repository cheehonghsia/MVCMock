package com.chhsia.mvc.service;

import java.util.List;

import com.chhsia.mvc.model.Person;

public interface PersonService {
	
	public void addPerson(Person person);
	
	public List<Person> findAllPersons();

	public Person findPersonById(int id);

}
