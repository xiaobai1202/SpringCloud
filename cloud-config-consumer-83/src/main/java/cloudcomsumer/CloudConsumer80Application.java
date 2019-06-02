package cloudcomsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 自动生成的类
 * @author IDEA
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConsumer80Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudConsumer80Application.class, args);
    }

    /**
     * 由于容器中并没有为我们配置 RestTemplate  所以这里我们自己new 一个  交给容器管理
     * @return restemplate  交给Spring 管理
     */
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
