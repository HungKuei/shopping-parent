package com.hungkuei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PCWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(PCWebApplication.class,args);
    }
}
