package com.sapient.country;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CountryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountryServiceApplication.class, args);
	}

}
