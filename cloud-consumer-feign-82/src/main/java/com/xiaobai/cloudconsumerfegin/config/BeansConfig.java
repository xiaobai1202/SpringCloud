package com.xiaobai.cloudconsumerfegin.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author xiaobai
 * @date 2019/5/29 14:50
 * @since 1.0
 * 用来配置要用到的bean
 */
@Configuration
public class BeansConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
