package com.chhsia.mvc.dao;

import java.util.List;

import com.chhsia.mvc.model.Person;

public interface PersonDao {
	
	public void addPerson(Person person);

	public List<Person> findAllPersons();

	public Person findPersonById(int id);

}
