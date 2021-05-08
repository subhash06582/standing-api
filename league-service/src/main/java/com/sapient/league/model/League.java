package com.sapient.league.model;

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

	public long getCountryId() {
		return countryId;
	}

	public void setCountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public long getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(long leagueId) {
		this.leagueId = leagueId;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	@Override
	public String toString() {
		return "League [countryId=" + countryId + ", countryName=" + countryName + ", leagueId=" + leagueId
				+ ", leagueName=" + leagueName + "]";
	}
	
	
}
