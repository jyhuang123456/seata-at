package com.easy.id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigurationProperties
@EnableEurekaClient
public class EasyIdGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(EasyIdGeneratorApplication.class, args);
    }
}
