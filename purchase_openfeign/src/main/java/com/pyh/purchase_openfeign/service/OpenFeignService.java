package com.pyh.purchase_openfeign.service;

import com.pyh.comutils.json.ComResult;
import com.pyh.comutils.pojo.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "PAYMENTSERVICE")
public interface OpenFeignService {


    @GetMapping("/create")
    public ComResult<Payment> create(Payment payment);

    @GetMapping("/select/{id}")
    public ComResult<Payment> getPaymentById(@PathVariable("id")Long id);
}
