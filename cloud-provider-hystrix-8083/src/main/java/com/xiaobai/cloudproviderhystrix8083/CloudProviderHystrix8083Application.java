package com.xiaobai.cloudproviderhystrix8083;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author IDEA
 * IDEA 自动生成的启动类
 * @EnableCircuitBreaker  启动熔断机制
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class CloudProviderHystrix8083Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderHystrix8083Application.class, args);
    }

}
