package com.pyh.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator getRouteLocator(RouteLocatorBuilder builder)
    {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("Route_JavaConfig",r->r.path("/guonei")
        .uri("http://news.baidu.com/"))//URI最后带不带"/"都可以的
                .build();
        routes.route("Route_JavaConfig",r->r.path("/guoji")
                .uri("http://news.baidu.com"))
                .build();
        return routes.build();
    }
}
