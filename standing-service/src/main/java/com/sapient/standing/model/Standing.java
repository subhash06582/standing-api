package com.sapient.standing.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Standing {
	
	@JsonProperty("country_name")
	private String countryName;
	
	@JsonProperty("league_id")
	private long leagueId;
	
	@JsonProperty("league_name")
	private String leagueName;
	
	@JsonProperty("team_id")
	private String teamId;
	
	@JsonProperty("team_name")
	private String teamName;
	
	@JsonProperty("overall_league_position")
	private String overallLeaguePosition;
}
