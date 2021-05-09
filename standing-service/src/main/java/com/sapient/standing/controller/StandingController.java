package com.sapient.standing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.standing.model.Standing;
import com.sapient.standing.service.StandingService;

@RestController
public class StandingController {

	@Autowired
	private StandingService service;

	@GetMapping("/standings")
	public List<Standing> getStandings(@RequestParam("leagueId") long leagueId) throws Exception {
		return service.getStanding(leagueId);
	}

}
