package com.hungkuei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 会员服务
 */
@SpringBootApplication
@EnableEurekaClient
public class MemberServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MemberServerApplication.class, args);
    }
}
