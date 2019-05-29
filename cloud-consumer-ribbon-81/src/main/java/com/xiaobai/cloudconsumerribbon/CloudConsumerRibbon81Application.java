package com.xiaobai.cloudconsumerribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 自动生成的启动类
 * @author IDEA
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-provider")
public class CloudConsumerRibbon81Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerRibbon81Application.class, args);
    }

    /**
     * 由于容器中并没有为我们配置 RestTemplate  所以这里我们自己new 一个  交给容器管理
     * 使用loadBalanced 进行负载均衡 必须制定微服务的名称
     * @return restTemplate  交给Spring 管理
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
