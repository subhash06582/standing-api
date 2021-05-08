package com.sapient.position.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class LeaguePosition {
	
	@JsonProperty("Country ID & Name: ")
	private String countryIdAndName;
	
	@JsonProperty("League ID & Name: ")
	private String leagueIdAndName;
	
	@JsonProperty("Team ID & Name: ")
	private String teamIdAndName;
	
	@JsonProperty("Overall League Position: ")
	private String overallLeaguePosition;
}
