package com.example.storeproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class StoreProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreProductApplication.class, args);
	}
}
