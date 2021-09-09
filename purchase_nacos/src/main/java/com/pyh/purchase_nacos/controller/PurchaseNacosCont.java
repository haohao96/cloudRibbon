package com.pyh.purchase_nacos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class PurchaseNacosCont {

    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @GetMapping("/purchase/select/{id}")
    public String select(@PathVariable("id")Long id)
    {
        System.out.println("进入了select");
        return restTemplate.getForObject(serviceUrl+"/select/"+id,String.class);
    }

    @GetMapping("/purchase/test")
    public String test()
    {
        return "test";
    }

}
