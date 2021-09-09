package com.pyh.purchase_nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PurchaseNacosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseNacosApplication.class, args);
	}

}
