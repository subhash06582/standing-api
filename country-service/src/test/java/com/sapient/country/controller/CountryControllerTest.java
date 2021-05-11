package com.sapient.country.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.country.model.Country;
import com.sapient.country.service.CountryService;

@ExtendWith(MockitoExtension.class)
public class CountryControllerTest {

	@InjectMocks
	private CountryController countryController;

	@Mock
	private CountryService countryService;

	@Test
	public void getCountriesTest() throws Exception {
		List<Country> countryList = getCountryList();
		when(countryService.getCountries()).thenReturn(countryList);
		List<Country> countries = countryController.getCountries();
		assertEquals(countries.get(0).getCountryId(), countryList.get(0).getCountryId());
		assertEquals(countries.get(0).getCountryName(), countryList.get(0).getCountryName());
	}

	private List<Country> getCountryList() {
		Country country = new Country();
		country.setCountryId(1);
		country.setCountryName("England");
		List<Country> countryList = Collections.singletonList(country);
		return countryList;
	}
}
