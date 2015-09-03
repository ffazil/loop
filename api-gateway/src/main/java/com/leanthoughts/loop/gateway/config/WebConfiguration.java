package com.leanthoughts.loop.gateway.config;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ffl
 * @since 26-06-2015
 */
@Configuration
@EnableCircuitBreaker
@ComponentScan(basePackages = {"com.leanthoughts.loop.gateway.web"})
public class WebConfiguration {



}
