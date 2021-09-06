package com.pyh.payment.controller;

import com.pyh.comutils.json.ComResult;
import com.pyh.comutils.pojo.Payment;
import com.pyh.payment.dao.PaymentDao;
import com.pyh.payment.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private int serverPort;

    @Resource
    private PayMapper payMapper;

    @Resource
    private PaymentDao paymentDao;

    @PostMapping("/create")
    public ComResult create(@RequestBody Payment payment)
    {
        paymentDao.create(payment);
        Long res=payment.getId();
        return new ComResult<>(200,"插入成功,serverPort:"+serverPort,res);
    }

    @GetMapping("/select/{id}")
    public ComResult getPaymentById(@PathVariable("id")Long id)
    {
        Payment payment=paymentDao.getPaymentById(id);
        return new ComResult<>(200,"查询成功,serverPort:"+serverPort,payment);
    }

    @GetMapping("/niubi")
    public String test()
    {
//        int a=8/0;
        return "我是提供方1的test方法";
    }

    //测试fallback的解耦写法
    @GetMapping("/jieou")
    public String jieou()
    {
//        int a=6/0;
        return "我是提供方1的jieou方法 ";
    }

    @GetMapping("/timeout")
    public int timeOutTest() throws InterruptedException {
        Thread.sleep(3000);
        return serverPort;
    }
}
