package com.pyh.zk.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class payment_zk_Cont {

    @Value("${server.port}")
    private String serverport;

    private Random random=new Random(7);

    @RequestMapping("/paymentzk")
    public String paymentzk()
    {
        return "spring cloud with zookeeper,server port:"+serverport+"--"+ random.nextInt(7);
    }
}
