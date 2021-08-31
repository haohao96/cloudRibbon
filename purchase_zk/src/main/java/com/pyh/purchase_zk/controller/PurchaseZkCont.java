package com.pyh.purchase_zk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PurchaseZkCont {
    public static final String INVOKE_URL="http://zookeeperPayment";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/purchasezk")
    public String purchasezk()
    {
        String res=restTemplate.getForObject(INVOKE_URL+"/paymentzk",String.class);
        return res;
    }

}
