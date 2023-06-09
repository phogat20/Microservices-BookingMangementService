package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Ms01RatingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Ms01RatingServiceApplication.class, args);
	}

}
