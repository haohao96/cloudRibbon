package com.pyh.purchase_hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pyh.comutils.json.ComResult;
import com.pyh.comutils.pojo.Payment;
import com.pyh.purchase_hystrix.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PurchaseHystrixCont {

    @Value("${server.port}")
    private int serverPort;

    @Resource
    private HystrixService service;

    @GetMapping("/purchase/create")
    public ComResult<Payment> create(Payment payment)
    {
        return service.create(payment);
    }

    @GetMapping("/purchase/select/{id}")
    public ComResult<Payment> getPaymentById(@PathVariable("id")Long id)
    {
        System.out.println("consumer port:"+serverPort);
        return service.getPaymentById(id);
    }

    @GetMapping("/purchase/timeout")
    @HystrixCommand(fallbackMethod = "timeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
            value = "6000")})
    public String timeOutTest()
    {
        return service.timeOutTest();
    }

    public String timeOutHandler()
    {
        return "我是消费端，对不起，出错了！";
    }

    @GetMapping("/purchase/niubi")
    public String test()
    {
//        int a=6/0;
        return service.test();
    }

    @GetMapping("/purchase/jieou")
    public String jieou()
    {
//        int a=6/0;
        return service.jieou();
    }
}
