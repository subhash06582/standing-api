
package com.sapient.league.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.league.model.League;
import com.sapient.league.service.LeagueService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
public class LeagueController {

	@Autowired
	private LeagueService service;

	private Logger logger = LoggerFactory.getLogger(LeagueController.class);

	@GetMapping("/leagues")
	@CircuitBreaker(name = "leagueService", fallbackMethod = "fallbackLeagues")
	public List<League> getLeagues(@RequestParam("countryId") long countryId) throws Exception {
		return service.getLeagues(countryId);
	}

	public List<League> fallbackLeagues(Exception ex) {
		List<League> leagues = Arrays.asList(new League(41, "England", 149, "Championship"),
				new League(46, "France", 177, "Ligue 2"));
		if (logger.isDebugEnabled()) {
			logger.debug("fallbackLeagues :: {}", leagues);
		}
		return leagues;
	}

}
