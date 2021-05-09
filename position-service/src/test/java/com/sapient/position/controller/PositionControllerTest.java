package com.sapient.position.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.position.model.LeaguePosition;
import com.sapient.position.model.LeaguePositionFilter;
import com.sapient.position.service.PositionService;

@ExtendWith(MockitoExtension.class)
public class PositionControllerTest {

	@InjectMocks
	private PositionController positionController;

	@Mock
	private PositionService positionService;

	@Test
	public void getPosition() throws Exception {
		LeaguePosition leaguePosition = getLeaguePosition();
		when(positionService.getPosition(any())).thenReturn(leaguePosition);
		LeaguePosition responseLeaguePosition = positionController.getPosition(new LeaguePositionFilter());
		assertEquals(responseLeaguePosition.getCountryIdAndName(), leaguePosition.getCountryIdAndName());
		assertEquals(responseLeaguePosition.getLeagueIdAndName(), leaguePosition.getLeagueIdAndName());
		assertEquals(responseLeaguePosition.getTeamIdAndName(), leaguePosition.getTeamIdAndName());
		assertEquals(responseLeaguePosition.getOverallLeaguePosition(), leaguePosition.getOverallLeaguePosition());
	}

	private LeaguePosition getLeaguePosition() {
		LeaguePosition leaguePosition = new LeaguePosition();
		leaguePosition.setCountryIdAndName("1 - England");
		leaguePosition.setLeagueIdAndName("11 - EPL");
		leaguePosition.setTeamIdAndName("111 - Manchester United");
		leaguePosition.setOverallLeaguePosition("1");
		return leaguePosition;
	}
}