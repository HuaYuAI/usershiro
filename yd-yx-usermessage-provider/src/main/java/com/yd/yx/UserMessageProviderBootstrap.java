package com.yd.yx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;

/**
 * Created by huayu on 2019/8/15.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableCircuitBreaker
@Controller
public class UserMessageProviderBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(UserMessageProviderBootstrap.class, args);
    }

}
