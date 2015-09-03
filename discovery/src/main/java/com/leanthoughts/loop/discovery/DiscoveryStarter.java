package com.leanthoughts.loop.discovery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
@EnableEurekaClient
@Slf4j
public class DiscoveryStarter {
	public static void main(String[] args) {
		new SpringApplicationBuilder(DiscoveryStarter.class).web(true).run(args);
	}
}
