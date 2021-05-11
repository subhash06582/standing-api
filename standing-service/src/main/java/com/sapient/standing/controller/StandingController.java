package com.sapient.standing.controller;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.standing.model.Standing;
import com.sapient.standing.service.StandingService;

import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class StandingController {

	@Autowired
	private StandingService service;

	private Logger logger = LoggerFactory.getLogger(StandingController.class);

	@GetMapping("/standings")
	@Retry(name = "standingService", fallbackMethod = "fallbackStandingList")
	public List<Standing> getStandings(@RequestParam("leagueId") long leagueId) throws Exception {
		return service.getStanding(leagueId);
	}

	public List<Standing> fallbackStandingList(Exception ex) {
		List<Standing> standings = Arrays.asList(
				new Standing("England", 149, "Championship", "2641", "Norwich", "1"),
				new Standing("France", 177, "Ligue 2", "3042", "Clermont", "2"));
		if (logger.isDebugEnabled()) {
			logger.debug("fallbackStandingList :: {}", standings);
		}
		return standings;
	}

}
