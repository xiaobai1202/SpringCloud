package com.xiaobai.cloudconsumerfegin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * IDEA 自动生成
 * @author IDEA
 * 注意 ！！当我们使用自定义的ComponentScan的时候，组合注解SpringBootApplication中的ComponentScan就失效了
 * 这时我们需要将该模块中需要扫描的包也写到自定义的ComponentScan中！！！！否则就不会被扫描到容器中
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.xiaobai.service"})
@ComponentScan({"com.xiaobai.fallback","com.xiaobai.cloudconsumerfegin"})
public class CloudConsumerFegin82Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerFegin82Application.class, args);
    }

}
