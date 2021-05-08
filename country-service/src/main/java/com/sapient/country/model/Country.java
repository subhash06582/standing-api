package com.sapient.country.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Country {
	
	@JsonProperty("country_id")
	private long countryId;
	
	@JsonProperty("country_name")
	private String countryName;
	
}
