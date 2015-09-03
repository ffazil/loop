package com.leanthoughts.loop.gateway;

import com.leanthoughts.loop.gateway.config.YamlInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author FFL
 * @since 02-03-2015
 */
@SpringBootApplication
@EnableSidecar
@ComponentScan(basePackages = "com.leanthoughts.loop.gateway.config")
public class GatewayStarter {
	private static final Logger LOG = LoggerFactory.getLogger(GatewayStarter.class);

    public static void main(String[] args) {
        new SpringApplicationBuilder(GatewayStarter.class).web(true).run(args);
    }
}
