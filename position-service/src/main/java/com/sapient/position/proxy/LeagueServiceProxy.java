package com.sapient.position.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.position.model.League;

@FeignClient(value = "league-service")
public interface LeagueServiceProxy {

	@GetMapping("/api/leagues")
	public List<League> getLeagues(@RequestParam("countryId") long countryId) throws Exception;

}
