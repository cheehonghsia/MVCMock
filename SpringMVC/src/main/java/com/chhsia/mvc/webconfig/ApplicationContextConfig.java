package com.chhsia.mvc.webconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.chhsia.mvc.controller.MyController;
import com.chhsia.mvc.dao.PersonDaoImpl;
import com.chhsia.mvc.service.PersonServiceImpl;

/**
 * @author Chee-Hong This class replace the standard applicationContext.xml.
 *
 */
@Configuration
@EnableWebMvc // equivalent to <mvc:annotation-driven />
@ComponentScan(basePackageClasses = { MyController.class, PersonDaoImpl.class, PersonServiceImpl.class })
public class ApplicationContextConfig extends WebMvcConfigurationSupport {

	@Bean(name = "viewResolver")
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

}
