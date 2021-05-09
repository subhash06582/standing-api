package com.sapient.position.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.position.constant.PositionConstants;
import com.sapient.position.exception.SearchApiException;
import com.sapient.position.model.Country;
import com.sapient.position.model.League;
import com.sapient.position.model.LeaguePosition;
import com.sapient.position.model.LeaguePositionFilter;
import com.sapient.position.model.Standing;
import com.sapient.position.proxy.CountryServiceProxy;
import com.sapient.position.proxy.LeagueServiceProxy;
import com.sapient.position.proxy.StandingServiceProxy;

@Service
public class PositionService {

	@Autowired
	private CountryServiceProxy countryService;

	@Autowired
	private LeagueServiceProxy leagueService;

	@Autowired
	private StandingServiceProxy standingService;

	private Logger logger = LoggerFactory.getLogger(PositionService.class);

	public LeaguePosition getPosition(LeaguePositionFilter filter) throws Exception {
		Country country = getCountry(filter);
		League league = getLeague(filter, country);
		Standing standing = getStanding(filter, league);
		return populateLeagueStanding(country, standing);
	}

	private Country getCountry(LeaguePositionFilter filter) {

		Country country;

		Optional<Country> firstCountry = countryService.getCountries().stream()
				.filter(current -> filter.getCountry().equalsIgnoreCase(current.getCountryName())).findFirst();

		if (firstCountry.isPresent()) {
			country = firstCountry.get();
			if (logger.isDebugEnabled()) {
				logger.debug("getCountry :: {}", country);
			}
		} else {
			throw new SearchApiException("invalid country name");
		}

		return country;
	}

	private League getLeague(LeaguePositionFilter filter, Country country) throws Exception {
		League league;
		Optional<League> firstLeague = leagueService.getLeagues(country.getCountryId()).stream()
				.filter(current -> filter.getLeague().equalsIgnoreCase(current.getLeagueName())).findFirst();

		if (firstLeague.isPresent()) {
			league = firstLeague.get();
			if (logger.isDebugEnabled()) {
				logger.debug("getLeague :: {}", league);
			}
		} else {
			throw new SearchApiException("invalid league name");
		}

		return league;
	}

	private Standing getStanding(LeaguePositionFilter filter, League league) throws Exception {

		Standing standing;

		Optional<Standing> firstStanding = standingService.getStandings(league.getLeagueId()).stream()
				.filter(current -> filter.getTeam().equalsIgnoreCase(current.getTeamName())).findFirst();

		if (firstStanding.isPresent()) {
			standing = firstStanding.get();
			if (logger.isDebugEnabled()) {
				logger.debug("getStanding :: {}", standing);
			}
		} else {
			throw new SearchApiException("invalid team name");
		}

		return standing;
	}

	private LeaguePosition populateLeagueStanding(Country country, Standing standing) {
		LeaguePosition position = new LeaguePosition();
		position.setCountryIdAndName(country.getCountryId() + PositionConstants.HYPHEN + country.getCountryName());
		position.setLeagueIdAndName(standing.getLeagueId() + PositionConstants.HYPHEN + standing.getLeagueName());
		position.setTeamIdAndName(standing.getTeamId() + PositionConstants.HYPHEN + standing.getTeamName());
		position.setOverallLeaguePosition(standing.getOverallLeaguePosition());
		if (logger.isDebugEnabled()) {
			logger.debug("populateLeagueStanding :: {}", position);
		}
		return position;
	}
}
