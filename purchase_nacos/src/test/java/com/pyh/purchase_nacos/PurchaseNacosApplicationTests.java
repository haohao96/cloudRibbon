package com.pyh.purchase_nacos;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PurchaseNacosApplicationTests {

	@Value("${service-url.nacos-user-service}")
	private String serviceUrl;
	@Test
	void contextLoads() {
		System.out.println(serviceUrl);
	}

}
