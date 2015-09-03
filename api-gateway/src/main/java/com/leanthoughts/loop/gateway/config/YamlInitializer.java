package com.leanthoughts.loop.gateway.config;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

/**
 * Created by sadath on 26-Jun-2015.
 */
public class YamlInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public void initialize(ConfigurableApplicationContext applicationContext) {
        ConfigurableEnvironment env = applicationContext.getEnvironment();
        try {
            YamlPropertySourceLoader loader = new YamlPropertySourceLoader();
            PropertySource applicationYamlPropertySource = loader.load("application.yml", new ClassPathResource("application.yml"), null);
            env.getPropertySources().addFirst(applicationYamlPropertySource);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}