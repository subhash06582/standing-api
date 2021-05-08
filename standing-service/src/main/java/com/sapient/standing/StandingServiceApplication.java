package com.sapient.standing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class StandingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandingServiceApplication.class, args);
	}

}
