package com.sapient.position.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.position.model.Standing;

@FeignClient(value = "standing-service")
public interface StandingServiceProxy {

	@GetMapping("/api/standings")
	public List<Standing> getStandings(@RequestParam("leagueId") long leagueId) throws Exception;

}
