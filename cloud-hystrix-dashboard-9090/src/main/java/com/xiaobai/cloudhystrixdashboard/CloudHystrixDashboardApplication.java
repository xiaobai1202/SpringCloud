package com.xiaobai.cloudhystrixdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author IDEA
 * IDEA 自动生成
 */
@EnableHystrixDashboard
@SpringBootApplication
public class CloudHystrixDashboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudHystrixDashboardApplication.class, args);
    }

}
