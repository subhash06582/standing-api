package com.sapient.position.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sapient.position.exception.SearchApiException;
import com.sapient.position.model.Country;
import com.sapient.position.model.League;
import com.sapient.position.model.LeaguePosition;
import com.sapient.position.model.LeaguePositionFilter;
import com.sapient.position.model.Standing;
import com.sapient.position.proxy.CountryServiceProxy;
import com.sapient.position.proxy.LeagueServiceProxy;
import com.sapient.position.proxy.StandingServiceProxy;

@ExtendWith(MockitoExtension.class)
public class PositionServiceTest {

	@InjectMocks
	private PositionService positionService;

	@Mock
	private CountryServiceProxy countryService;

	@Mock
	private LeagueServiceProxy leagueService;

	@Mock
	private StandingServiceProxy standingService;

	@Test
	public void getPositionInIdealCondition() throws Exception {
		LeaguePositionFilter leaguePositionFilter = new LeaguePositionFilter();
		leaguePositionFilter.setCountry("England");
		leaguePositionFilter.setLeague("EPL");
		leaguePositionFilter.setTeam("Manchester United");

		Country country = new Country();
		country.setCountryId(1);
		country.setCountryName("England");
		List<Country> countryList = Collections.singletonList(country);

		League league = new League();
		league.setCountryId(1);
		league.setCountryName("England");
		league.setLeagueId(11);
		league.setLeagueName("EPL");
		List<League> leagueList = Collections.singletonList(league);

		Standing standing = new Standing();
		standing.setCountryName("England");
		standing.setLeagueId(11);
		standing.setLeagueName("EPL");
		standing.setOverallLeaguePosition("1");
		standing.setTeamId("111");
		standing.setTeamName("Manchester United");

		List<Standing> standingList = Collections.singletonList(standing);

		when(countryService.getCountries()).thenReturn(countryList);
		when(leagueService.getLeagues(anyLong())).thenReturn(leagueList);
		when(standingService.getStandings(anyLong())).thenReturn(standingList);
		
		LeaguePosition responseLeaguePosition = positionService.getPosition(leaguePositionFilter);
		
		assertEquals("1 - England", responseLeaguePosition.getCountryIdAndName());
		assertEquals("11 - EPL", responseLeaguePosition.getLeagueIdAndName());
		assertEquals("111 - Manchester United", responseLeaguePosition.getTeamIdAndName());
		assertEquals("1", responseLeaguePosition.getOverallLeaguePosition());
	}

	@Test
	public void getPositionThrowsInvalidCountryNameException_WhenCountryNameNotFound() throws Exception {

		LeaguePositionFilter leaguePositionFilter = new LeaguePositionFilter();
		leaguePositionFilter.setCountry("UnknownCountryName");
		leaguePositionFilter.setLeague("EPL");
		leaguePositionFilter.setTeam("Manchester United");

		Country country = new Country();
		country.setCountryId(1);
		country.setCountryName("England");
		List<Country> countryList = Collections.singletonList(country);

		when(countryService.getCountries()).thenReturn(countryList);

		assertThrows(SearchApiException.class, () -> positionService.getPosition(leaguePositionFilter));
	}

	@Test
	public void getPositionThrowsInvalidLeagueNameException_WhenLeagueNameNotFound() throws Exception {

		LeaguePositionFilter leaguePositionFilter = new LeaguePositionFilter();
		leaguePositionFilter.setCountry("England");
		leaguePositionFilter.setLeague("UnknownLeagueName");
		leaguePositionFilter.setTeam("Manchester United");

		Country country = new Country();
		country.setCountryId(1);
		country.setCountryName("England");
		List<Country> countryList = Collections.singletonList(country);

		League league = new League();
		league.setCountryId(1);
		league.setCountryName("England");
		league.setLeagueId(11);
		league.setLeagueName("EPL");
		List<League> leagueList = Collections.singletonList(league);

		when(countryService.getCountries()).thenReturn(countryList);
		when(leagueService.getLeagues(anyLong())).thenReturn(leagueList);
		assertThrows(SearchApiException.class, () -> positionService.getPosition(leaguePositionFilter));
	}

	@Test
	public void getPositionThrowsInvalidTeamNameException_WhenTeamNameNotFound() throws Exception {

		LeaguePositionFilter leaguePositionFilter = new LeaguePositionFilter();
		leaguePositionFilter.setCountry("England");
		leaguePositionFilter.setLeague("EPL");
		leaguePositionFilter.setTeam("UnknownTeamName");

		Country country = new Country();
		country.setCountryId(1);
		country.setCountryName("England");
		List<Country> countryList = Collections.singletonList(country);

		League league = new League();
		league.setCountryId(1);
		league.setCountryName("England");
		league.setLeagueId(11);
		league.setLeagueName("EPL");
		List<League> leagueList = Collections.singletonList(league);

		Standing standing = new Standing();
		standing.setCountryName("England");
		standing.setLeagueId(11);
		standing.setLeagueName("EPL");
		standing.setOverallLeaguePosition("1");
		standing.setTeamId("111");
		standing.setTeamName("Manchester United");

		List<Standing> standingList = Collections.singletonList(standing);

		when(countryService.getCountries()).thenReturn(countryList);
		when(leagueService.getLeagues(anyLong())).thenReturn(leagueList);
		when(standingService.getStandings(anyLong())).thenReturn(standingList);
		assertThrows(SearchApiException.class, () -> positionService.getPosition(leaguePositionFilter));
	}

	@Test
	public void getPositionThrowsException_WhenCountryServiceUnavailable() throws Exception {

		LeaguePositionFilter leaguePositionFilter = new LeaguePositionFilter();
		leaguePositionFilter.setCountry("UnknownCountryName");
		leaguePositionFilter.setLeague("EPL");
		leaguePositionFilter.setTeam("Manchester United");

		when(countryService.getCountries()).thenThrow(new RuntimeException("Country Svc Unavailable"));

		assertThrows(RuntimeException.class, () -> positionService.getPosition(leaguePositionFilter));
		verify(countryService, times(1)).getCountries();
		verify(leagueService, times(0)).getLeagues(anyLong());
		verify(standingService, times(0)).getStandings(anyLong());
	}

	@Test
	public void getPositionThrowsException_WhenLeagueServiceUnavailable() throws Exception {

		LeaguePositionFilter leaguePositionFilter = new LeaguePositionFilter();
		leaguePositionFilter.setCountry("England");
		leaguePositionFilter.setLeague("UnknownLeagueName");
		leaguePositionFilter.setTeam("Manchester United");

		Country country = new Country();
		country.setCountryId(1);
		country.setCountryName("England");
		List<Country> countryList = Collections.singletonList(country);

		when(countryService.getCountries()).thenReturn(countryList);
		when(leagueService.getLeagues(anyLong())).thenThrow(new RuntimeException("League Service Unavailable"));
		assertThrows(RuntimeException.class, () -> positionService.getPosition(leaguePositionFilter));
		verify(countryService, times(1)).getCountries();
		verify(leagueService, times(1)).getLeagues(anyLong());
		verify(standingService, times(0)).getStandings(anyLong());
	}

	@Test
	public void getPositionThrowsException_WhenStandingServiceUnavailable() throws Exception {

		LeaguePositionFilter leaguePositionFilter = new LeaguePositionFilter();
		leaguePositionFilter.setCountry("England");
		leaguePositionFilter.setLeague("EPL");
		leaguePositionFilter.setTeam("UnknownTeamName");

		Country country = new Country();
		country.setCountryId(1);
		country.setCountryName("England");
		List<Country> countryList = Collections.singletonList(country);

		League league = new League();
		league.setCountryId(1);
		league.setCountryName("England");
		league.setLeagueId(11);
		league.setLeagueName("EPL");
		List<League> leagueList = Collections.singletonList(league);

		when(countryService.getCountries()).thenReturn(countryList);
		when(leagueService.getLeagues(anyLong())).thenReturn(leagueList);
		when(standingService.getStandings(anyLong())).thenThrow(new RuntimeException("Standing Service Unavailable"));

		assertThrows(RuntimeException.class, () -> positionService.getPosition(leaguePositionFilter));
		verify(countryService, times(1)).getCountries();
		verify(leagueService, times(1)).getLeagues(anyLong());
		verify(standingService, times(1)).getStandings(anyLong());
	}

}
