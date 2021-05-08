package com.sapient.country.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.sapient.country.model.Country;

@FeignClient(value = "apifootball", url = "${feign.apifootball.url}", configuration = FeignClientConfiguration.class)
public interface ApiFootballProxy {

	@GetMapping(value = "/?action=get_countries")
	List<Country> getCountries();
}
