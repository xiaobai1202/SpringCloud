package com.xiaobai.cloudgatewayzuul1202;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author IDEA
 * IDEA自动生成的代码
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class CloudGatewayZuul1202Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudGatewayZuul1202Application.class, args);
    }

}
