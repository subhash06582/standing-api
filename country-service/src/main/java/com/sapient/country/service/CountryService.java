package com.sapient.country.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.country.model.Country;
import com.sapient.country.proxy.ApiFootballProxy;

@Service
public class CountryService {

	@Autowired
	private ApiFootballProxy proxy;

	private Logger logger = LoggerFactory.getLogger(CountryService.class);

	public List<Country> getCountries() {

		List<Country> countries = proxy.getCountries();

		if (logger.isDebugEnabled()) {
			logger.debug("getCountry :: {}", countries);
		}

		return countries;
	}
}
