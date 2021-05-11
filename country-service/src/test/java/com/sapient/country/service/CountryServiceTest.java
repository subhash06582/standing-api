package com.sapient.country.service;

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
import com.sapient.country.proxy.ApiFootballProxy;

@ExtendWith(MockitoExtension.class)
public class CountryServiceTest {

	@InjectMocks
	private CountryService countryService;

	@Mock
	private ApiFootballProxy proxy;

	@Test
	public void getCountriesTest() {
		List<Country> countryList = getMockCounytries();
		when(proxy.getCountries()).thenReturn(getMockCounytries());
		List<Country> countries = countryService.getCountries();
		assertEquals(countries.get(0).getCountryId(), countryList.get(0).getCountryId());
		assertEquals(countries.get(0).getCountryName(), countryList.get(0).getCountryName());
	}

	private List<Country> getMockCounytries() {
		Country country = new Country();
		country.setCountryId(1);
		country.setCountryName("England");
		List<Country> countryList = Collections.singletonList(country);
		return countryList;
	}
}
