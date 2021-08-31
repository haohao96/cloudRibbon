package com.pyh.zk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Payment_zk {

	public static void main(String[] args) {
		SpringApplication.run(Payment_zk.class, args);
	}

}
