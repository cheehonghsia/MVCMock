package com.chhsia.mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import com.chhsia.mvc.model.Person;
import com.chhsia.mvc.root.TestContext;
import com.chhsia.mvc.service.PersonService;

/**
 * @author Chee-Hong
 * http://blog.trifork.com/2012/12/11/properly-testing-spring-mvc-controllers/
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestContext.class })
@WebAppConfiguration
public class MyControllerTest {

	@InjectMocks
	private MyController controller;

	@Mock
	private PersonService mockedPersonService;

	@Mock
	private View mockView;

	private MockMvc mockMvc;

	@Before
	public void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);	
		mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(mockView).build();

	}

	@Test
	public void testWelcomePage() throws Exception {

		mockMvc.perform(get("/"))

		.andExpect(status().isOk())

		.andExpect(view().name("index"));

	}
	
	@Test
	public void testFindAllPersons() throws Exception {

		List<Person> expectedPeople = Arrays.asList(new Person("Cheehong"));

		Mockito.when(mockedPersonService.findAllPersons()).thenReturn(expectedPeople);

		mockMvc.perform(get("/persons"))

		.andExpect(status().isOk())

		.andExpect(model().attribute("persons", expectedPeople))

		.andExpect(view().name("persons"));

	}
	
	@Test
	public void testFindPerson() throws Exception {

		Person expectedPerson = new Person("Cheehong");

		Mockito.when(mockedPersonService.findPersonById(1)).thenReturn(expectedPerson);

		mockMvc.perform(get("/person/1"))

		.andExpect(status().isOk())

		.andExpect(model().attribute("person", expectedPerson))

		.andExpect(view().name("person"));

	}

}
