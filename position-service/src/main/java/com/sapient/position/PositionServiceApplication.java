package com.sapient.position;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PositionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PositionServiceApplication.class, args);
	}

}
