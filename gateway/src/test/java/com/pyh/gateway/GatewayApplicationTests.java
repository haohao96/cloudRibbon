package com.pyh.gateway;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;

@SpringBootTest
class GatewayApplicationTests {

	@Test
	void contextLoads() {

		ZonedDateTime nowTime=ZonedDateTime.now();
		System.out.println(nowTime);
	}

}
