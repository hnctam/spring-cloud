package com.ami.pcf.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    WebClient client() {
        return WebClient.builder()
                .build();
    }

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(r -> r.path("/api/v1/dcp/**")
                        .filters(f -> f.rewritePath("/api/v1/dcp/(?<remains>.*)", "/${remains}")
                                .addRequestHeader("X-first-Header", "dcp-service-header")
                                .hystrix(c -> c.setName("hystrix")
                                        .setFallbackUri("forward:/fallback/first")))
                        .uri("lb://dcp-service/")
                        .id("dcp-service"))

                .route(r -> r.path("/api/v1/dcp-validator/**")
                        .filters(f -> f.rewritePath("/api/v1/dcp-validator/(?<remains>.*)", "/${remains}")
                                .hystrix(c -> c.setName("hystrix")
                                        .setFallbackUri("forward:/fallback/second")))
                        .uri("lb://dcp-validator-service/")
                        .id("dcp-validator-service"))
                .build();
    }
}
