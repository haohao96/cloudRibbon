package com.pyh.payment;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class PaymentApplicationTests {

	@Resource
	private DiscoveryClient discoveryClient;

	@Test
	void contextLoads() {
		List<String> services = discoveryClient.getServices();
		for (String s:services)
		{
			System.out.println("service:"+s);
			List<ServiceInstance> instances = discoveryClient.getInstances(s);
			for (ServiceInstance inst:instances)
			{
				System.out.println(s+"--"+inst);
			}
			System.out.println();
			System.out.println();
		}


	}

}
