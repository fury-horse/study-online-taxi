package com.zacx.taxi.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class TaxiServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxiServiceUserApplication.class, args);
	}

}
