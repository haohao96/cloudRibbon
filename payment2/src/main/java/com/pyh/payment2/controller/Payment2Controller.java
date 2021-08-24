package com.pyh.payment2.controller;

import com.pyh.comutils.json.ComResult;
import com.pyh.comutils.pojo.Payment;
import com.pyh.payment2.dao.PaymentDao;
import com.pyh.payment2.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class Payment2Controller {

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
    public void rest()
    {}

}
