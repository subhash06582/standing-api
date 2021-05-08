package com.sapient.position.model;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class LeaguePositionFilter {
	
	@NotEmpty(message = "country name is required")
	private String country;
	
	@NotEmpty(message = "league name is required")
	private String league;
	
	@NotEmpty(message = "team name is required")
	private String team;
}
