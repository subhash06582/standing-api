package com.sapient.country.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.country.model.Country;
import com.sapient.country.service.CountryService;

@RestController
public class CountryController {

	@Autowired
	private CountryService service;

	@GetMapping("/countries")
	public List<Country> getCountries() throws Exception {
		return service.getCountries();
	}

}
