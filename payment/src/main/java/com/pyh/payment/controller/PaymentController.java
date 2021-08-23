package com.pyh.payment.controller;

import com.pyh.comutils.json.ComResult;
import com.pyh.comutils.pojo.Payment;
import com.pyh.payment.dao.PaymentDao;
import com.pyh.payment.mapper.PayMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PaymentController {


    @Autowired
    private PayMapper payMapper;

    @Autowired
    private PaymentDao paymentDao;

    @PostMapping("/create")
    public ComResult create(@RequestBody Payment payment)
    {
        paymentDao.create(payment);
        Long res=payment.getId();
        return new ComResult<>(200,"插入成功",res);
    }

    @GetMapping("/select/{id}")
    public ComResult getPaymentById(@PathVariable("id")Long id)
    {
        Payment payment=paymentDao.getPaymentById(id);
        return new ComResult<>(200,"查询成功",payment);
    }

    @GetMapping("/niubi")
    public void rest()
    {}

}
