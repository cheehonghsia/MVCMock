package com.chhsia.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chhsia.mvc.model.Person;
import com.chhsia.mvc.service.PersonService;

@Controller
public class MyController {
	
	@Autowired 
	private PersonService personService;
	
	/**
	 * Map incoming GET to index.jsp.
	 * @return index.jsp
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String initiateWelcomePage() {
		return "index";
	}
	
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String retrievePersons(ModelMap model) {
		
		List<Person> persons = personService.findAllPersons();
		
		model.addAttribute("persons", persons);
		
		return "persons";
	}
	
	@RequestMapping(value = "/person/{id}", method = RequestMethod.GET)
	public String retrievePerson(@PathVariable int id, ModelMap model) {
		
		Person person = personService.findPersonById(id);
		
		model.addAttribute("person", person);
		
		return "person";
	}
	
}
