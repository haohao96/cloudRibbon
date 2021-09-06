package com.pyh.purchase_openfeign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level openfeignLoggerLevel()
    {
        return Logger.Level.FULL;
    }
}
