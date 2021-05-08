package com.sapient.position.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class League {
	
	@JsonProperty("country_id")
	private long countryId;
	
	@JsonProperty("country_name")
	private String countryName;
	
	@JsonProperty("league_id")
	private long leagueId;
	
	@JsonProperty("league_name")
	private String leagueName;
}
