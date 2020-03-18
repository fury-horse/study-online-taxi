package com.zacx.taxi.gateway.passenger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class TaxiGatewayPassengerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiGatewayPassengerApplication.class, args);
	}

}
