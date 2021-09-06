package com.pyh.purchase_hystrix.service;

import com.pyh.comutils.json.ComResult;
import com.pyh.comutils.pojo.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "PAYMENTSERVICE",fallback = FallBackService.class)
public interface HystrixService {

    @GetMapping("/create")
    public ComResult<Payment> create(Payment payment);

    @GetMapping("/select/{id}")
    public ComResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @GetMapping("/timeout")
    public String timeOutTest();

    @GetMapping("/niubi")
    public String test();

    @GetMapping("/jieou")
    public String jieou();
}
