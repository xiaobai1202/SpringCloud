package com.xiaobai.cloudconsumerfegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * IDEA 自动生成
 * @author IDEA
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.xiaobai.service"})
public class CloudConsumerFegin82Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFegin82Application.class, args);
    }

}
