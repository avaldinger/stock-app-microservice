package com.avaldinger.portfolioservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PortfolioserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PortfolioserviceApplication.class, args);
	}

}
