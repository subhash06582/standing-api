package com.sapient.country.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.country.model.Country;
import com.sapient.country.service.CountryService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CountryController {

	@Autowired
	private CountryService service;

	private Logger logger = LoggerFactory.getLogger(CountryController.class);

	@GetMapping("/countries")
	@Retry(name = "countryService", fallbackMethod = "fallbackCountryList")
	public List<Country> getCountries() throws Exception {
		return service.getCountries();
	}

	public List<Country> fallbackCountryList(Exception ex) {
		List<Country> countries = Arrays.asList(new Country(41, "England"), new Country(46, "France"));
		if (logger.isDebugEnabled()) {
			logger.debug("fallbackCountryList :: {}", countries);
		}
		return countries;
	}

}
