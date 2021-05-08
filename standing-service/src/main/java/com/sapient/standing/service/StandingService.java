package com.sapient.standing.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.standing.model.Standing;
import com.sapient.standing.proxy.ApiFootballProxy;

@Service
public class StandingService {

	@Autowired
	private ApiFootballProxy proxy;

	private Logger logger = LoggerFactory.getLogger(StandingService.class);

	public List<Standing> getStanding(long leagueId) {

		List<Standing> standings = proxy.getStandings(leagueId);

		if (logger.isDebugEnabled()) {
			logger.debug("getStanding :: {}", standings);
		}

		return standings;

	}

}
