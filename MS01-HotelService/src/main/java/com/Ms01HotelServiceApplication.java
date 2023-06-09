package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Ms01HotelServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms01HotelServiceApplication.class, args);
	}

}
