
package com.sapient.league.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.league.model.League;
import com.sapient.league.service.LeagueService;

@RestController
public class LeagueController {

	@Autowired
	private LeagueService service;

	@GetMapping("/leagues")
	public List<League> getLeagues(@RequestParam("country") long countryId) throws Exception {
		return service.getLeagues(countryId);
	}

}
