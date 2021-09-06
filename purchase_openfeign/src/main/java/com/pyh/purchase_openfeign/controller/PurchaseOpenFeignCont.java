package com.pyh.purchase_openfeign.controller;

import com.pyh.comutils.json.ComResult;
import com.pyh.comutils.pojo.Payment;
import com.pyh.purchase_openfeign.service.OpenFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PurchaseOpenFeignCont {

    @Resource
    private OpenFeignService service;

    @GetMapping("/purchase/create")
    public ComResult<Payment> create(Payment payment)
    {
        return service.create(payment);
    }

    @GetMapping("/purchase/select/{id}")
    public ComResult<Payment> getPaymentById(@PathVariable("id")Long id)
    {
        return service.getPaymentById(id);
    }

    @GetMapping("/purchase/timeout")

    public int timeOutTest()
    {
        return service.timeOutTest();
    }
}
