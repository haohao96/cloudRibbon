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

    @GetMapping("/circuitbreaker/{a}")
    @HystrixCommand(fallbackMethod = "circuitbreakerHandler",commandProperties = {
            //开启熔断器
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            //设置窗口期，即熔断后过多久再次尝试访问此接口，以此看此接口是否恢复正常
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
//            在窗口期访问这个接口的总次数必须要达到此数值，如果没达到，就算全都访问这个接口失败也不会熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "6"),
//            访问这个接口失败的次数占总访问次数的比例超过此数值，则熔断，否则不熔断
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "50")
    })
    public String circuitbreaker(@PathVariable("a")int a)
    {
        if (a<8)
        {
            throw new RuntimeException("小于8");
        }
        return "我是提供方hystrix的circuitbreaker方法 ";
    }

    public String circuitbreakerHandler(@PathVariable("a")int a)
    {
        return "我是circuitbreakerHandler熔断后的处理方法，提供方hystrix";
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
