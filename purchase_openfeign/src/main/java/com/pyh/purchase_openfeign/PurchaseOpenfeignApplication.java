package com.pyh.purchase_openfeign;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@Slf4j
public class PurchaseOpenfeignApplication {

	public static void main(String[] args) {
		SpringApplication.run(PurchaseOpenfeignApplication.class, args);
	}

}
