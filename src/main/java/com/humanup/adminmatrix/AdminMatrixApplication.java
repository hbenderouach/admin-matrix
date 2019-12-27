package com.humanup.adminmatrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AdminMatrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminMatrixApplication.class, args);
	}

}
