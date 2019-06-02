package com.xiaobai.cloudconfig1213;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author IDEA
 * IDEA 自动生成的代码
 */
@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class CloudConfig1213Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfig1213Application.class, args);
    }

}
