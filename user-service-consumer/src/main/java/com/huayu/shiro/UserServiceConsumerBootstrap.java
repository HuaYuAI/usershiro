package com.huayu.shiro;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Created by huayu on 2019/6/1.
 */
@SpringCloudApplication
@EnableDiscoveryClient
public class UserServiceConsumerBootstrap {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceConsumerBootstrap.class,args);
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
