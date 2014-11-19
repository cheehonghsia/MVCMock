package com.chhsia.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chhsia.mvc.dao.PersonDao;
import com.chhsia.mvc.model.Person;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired PersonDao personDao;

	@Override
	public void addPerson(Person person) {
		
		personDao.addPerson(person);
		
	}

	@Override
	public List<Person> findAllPersons() {

		return personDao.findAllPersons();
		
	}

	@Override
	public Person findPersonById(int id) {
		
		return personDao.findPersonById(id);
	}

}
