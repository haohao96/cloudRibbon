package com.pyh.ribbonrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@RibbonClient(name = "PAYMENTSERVICE",configuration = RibbonRule.class)
public class RibbonRule {
    @Bean
    public IRule getRibbonRule()
    {
        return new RandomRule();
    }
}
