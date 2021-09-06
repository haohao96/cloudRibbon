package com.pyh.payment_hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableCircuitBreaker
public class PaymentHystrixApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentHystrixApplication.class, args);
	}

}
