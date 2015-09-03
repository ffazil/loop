package com.leanthoughts.loop.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author FFL
 * @Since 11-03-2015
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.leanthoughts.loop.auth.config")
public class AuthStarter {
    public static void main(String[] args) {
        SpringApplication.run(AuthStarter.class, args);
    }
}
