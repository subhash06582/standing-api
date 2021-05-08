package com.sapient.position.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.sapient.position.model.Country;

@FeignClient(value = "country-service")
public interface CountryServiceProxy {

	@GetMapping(value = "/api/countries")
	List<Country> getCountries();

}
