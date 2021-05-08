package com.sapient.standing.proxy;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sapient.standing.model.Standing;

@FeignClient(value = "apifootball", url = "${feign.apifootball.url}", configuration = FeignClientConfiguration.class)
public interface ApiFootballProxy {

	@GetMapping(value = "/?action=get_standings&{league_id}")
	List<Standing> getStandings(@RequestParam long league_id);

}
