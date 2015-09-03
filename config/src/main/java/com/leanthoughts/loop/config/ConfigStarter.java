package com.leanthoughts.loop.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
@EnableZuulProxy
public class ConfigStarter {
	public static void main(String[] args) {
        new SpringApplicationBuilder(ConfigStarter.class).web(true).run(args);
	}
}
