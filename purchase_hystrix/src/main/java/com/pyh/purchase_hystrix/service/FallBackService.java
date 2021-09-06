package com.pyh.purchase_hystrix.service;

import com.pyh.comutils.json.ComResult;
import com.pyh.comutils.pojo.Payment;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class FallBackService implements HystrixService {

    @Override
    public ComResult<Payment> create(Payment payment) {
        return null;
    }

    @Override
    public ComResult<Payment> getPaymentById(Long id) {
        return null;
    }

    @Override
    public String timeOutTest() {
        return null;
    }

    @Override
    public String test()
    {
        return "这样能解耦，我是消费方的test方法，异常了！";
    }

    @Override
    public String jieou() {
        return "这样能解耦，我是消费方的jieou方法，异常了！";
    }


}
