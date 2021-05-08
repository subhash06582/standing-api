package com.sapient.league.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.league.model.League;

@FeignClient(value = "apifootball", url = "${feign.apifootball.url}", configuration = FeignClientConfiguration.class)
public interface ApiFootballProxy {

	@GetMapping(value = "/?action=get_leagues&{country_id}")
	List<League> getLeagues(@RequestParam long country_id);

}
