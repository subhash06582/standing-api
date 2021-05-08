package com.sapient.league;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LeagueServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeagueServiceApplication.class, args);
	}

}
