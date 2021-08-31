package com.pyh.purchase_zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PurchaseZkApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseZkApplication.class, args);
	}

}
