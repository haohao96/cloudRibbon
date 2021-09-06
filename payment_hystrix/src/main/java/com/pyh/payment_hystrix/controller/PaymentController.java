package com.pyh.payment_hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.pyh.comutils.json.ComResult;
import com.pyh.comutils.pojo.Payment;
import com.pyh.payment_hystrix.dao.PaymentDao;
import com.pyh.payment_hystrix.mapper.PayMapper;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@DefaultProperties(defaultFallback = "globalExeHandler")
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
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        paymentDao.create(payment);
        Long res=payment.getId();
        return new ComResult<>(200,"插入成功,serverPort:"+serverPort,res);
    }

    @GetMapping("/select/{id}")
    public ComResult getPaymentById(@PathVariable("id")Long id)
    {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Payment payment=paymentDao.getPaymentById(id);
        return new ComResult<>(200,"查询成功,serverPort:"+serverPort,payment);
    }

    @HystrixCommand
    @GetMapping("/niubi")
    public String test()
    {
        int a=6/0;
        return "我是提供方的test方法";
    }

    //测试fallback的解耦写法
    @GetMapping("/jieou")
    public String jieou()
    {
        int a=6/0;
        return "我是提供方hystrix的jieou方法 ";
    }

    @GetMapping("/timeout")
    @HystrixCommand(fallbackMethod = "timeOutHanlder",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",
            value = "3000")})
    public String timeOutTest() throws InterruptedException {
        Thread.sleep(5000);
//        int a=6/0;
        return Integer.toString(serverPort) ;
    }

    public String timeOutHanlder() throws InterruptedException {
//        Thread.sleep(5000);
        return "我是提供方，不好意思，异常了，9.6日";
    }

//    这是全局服务降级 fallback，不用每个方法对应一个异常处理，
    public String globalExeHandler()
    {
        return "异常了，我是全局服务降级，我是提供方！";
    }
}
