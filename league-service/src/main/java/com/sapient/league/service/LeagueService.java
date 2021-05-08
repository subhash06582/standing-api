package com.sapient.league.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.league.model.League;
import com.sapient.league.proxy.ApiFootballProxy;

@Service
public class LeagueService {

	@Autowired
	private ApiFootballProxy proxy;

	private Logger logger = LoggerFactory.getLogger(LeagueService.class);

	public List<League> getLeagues(long countryId) {
		List<League> leagues = proxy.getLeagues(countryId);

		if (logger.isDebugEnabled()) {
			logger.debug("getLeagues :: {}", leagues);
		}

		return leagues;
	}
}
