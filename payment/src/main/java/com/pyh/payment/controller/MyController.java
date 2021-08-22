package com.pyh.payment.controller;

import com.pyh.payment.mapper.PayMapper;
import com.pyh.payment.pojo.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {


    @Autowired
    private PayMapper payMapper;

    @PostMapping("/create")
    public int create(Payment payment)
    {
        return payMapper.create(payment);
    }

    @GetMapping("/select/{id}")
    public Payment getPaymentById(@PathVariable("id")Long id)
    {
        return payMapper.getPaymentById(id);
    }

}
