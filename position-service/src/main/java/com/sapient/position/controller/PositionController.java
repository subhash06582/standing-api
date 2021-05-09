package com.sapient.position.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.position.model.LeaguePosition;
import com.sapient.position.model.LeaguePositionFilter;
import com.sapient.position.service.PositionService;

@RestController
public class PositionController {
	
	private Logger logger = LoggerFactory.getLogger(PositionController.class);
	
	@Autowired
	private PositionService service;

	@GetMapping("/position")
	public LeaguePosition getPosition(@Valid LeaguePositionFilter filter) throws Exception {
		if (logger.isDebugEnabled()) {
			logger.debug("getPosition :: {}", filter);
		}
		return service.getPosition(filter);
	}

}
