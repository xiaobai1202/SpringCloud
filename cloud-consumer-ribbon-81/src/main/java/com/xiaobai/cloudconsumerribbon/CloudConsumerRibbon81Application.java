package com.xiaobai.cloudconsumerribbon;

import com.netflix.loadbalancer.IRule;
import com.xiaobai.cloudconsumerribbon.ribbon.MyRibbonRule;
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

    /**
     * 配置我们个性化的负载均衡算法
     * 也就是说 同一时刻 只能有一个负载均衡算法
     * @return 负载均衡算法
     */
    @Bean
    public IRule iRule(){
        //轮询方式
//        return new RoundRobinRule();
        //随机方式
//        return new RandomRule();
        //轮询重试
//        return new RetryRule();
        //自定义负载均衡规则   5 次换结点
        return new MyRibbonRule();
        //其他的就不一一尝试了
    }
}
